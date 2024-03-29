package Lab4;

import Lab4.Actors.MainActor;
import Lab4.Messages.GetMessage;
import Lab4.Messages.PostMessage;
import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import akka.http.javadsl.server.AllDirectives;
import scala.concurrent.Future;


import java.io.IOException;
import java.util.concurrent.CompletionStage;


public class TesterJS extends AllDirectives {

    private final static String ROUTES = "routes";
    private final static String LOCALHOST = "localhost";
    private final static int LOCALHOST_PORT = 8080;
    private final static String SERVER_ONLINE_MESSAGE = "Server online at http://localhost:" + LOCALHOST_PORT + "/\nPress RETURN to stop...";
    private final static String POST_MESSAGE = "Message posted";

    private final static String PACKAGE_ID = "packageId";
    private final static int TIME_OUT_MILLS = 10000;

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create(ROUTES);
        ActorRef mainActor = system.actorOf(Props.create(MainActor.class));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        TesterJS testerJS = new TesterJS();

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = testerJS.testJsRoute(mainActor).flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost(LOCALHOST, LOCALHOST_PORT),
                materializer
        );

        System.out.println(SERVER_ONLINE_MESSAGE);
        System.in.read();

        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }

    private Route testJsRoute(ActorRef mainActor) {
        return concat(
                post(
                        () -> entity(
                                Jackson.unmarshaller(PostMessage.class), msg -> {
                                    mainActor.tell(msg, ActorRef.noSender());
                                    return complete(POST_MESSAGE);
                                }
                        )

                ),
                get(
                        () -> parameter(PACKAGE_ID, packageId -> {
                                    Future<Object> res = Patterns.ask(
                                            mainActor,
                                            new GetMessage(Integer.parseInt(packageId)),
                                            TIME_OUT_MILLS
                                    );
                                    return completeOKWithFuture(res, Jackson.marshaller());
                                }
                        )
                )
        );
    }


}
