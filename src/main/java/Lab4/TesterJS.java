package Lab4;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class Main {

    private final static String ROUTES = "routes";
    private final static String LOCALHOST = "localhost";
    private final static int LOCALHOST_PORT = 8080;
    private final static String SERVER_ONLINE_MESSAGE = "Server online at http://localhost:" + LOCALHOST_PORT + "/\nPress RETURN to stop...";

    public static void main(String[] args) throws IOException {
        ActorSystem system = ActorSystem.create("routes");
        ActorRef storeActor = system.actorOf(Props.create(StoreActros.class));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        MainHttp instance = new MainHttp(system);

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = instance.createRoute(system).flow(system, materializer);
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


}
