package Lab4.Actors;

import Lab4.Packages.PostMessage;
import Lab4.Packages.RunningMessage;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.routing.RoundRobinPool;

import javafx.util.Pair;


public class MainActor extends AbstractActor {

    private final static int MAX_ROUND_ROBIN_POOL = 5;

    ActorRef performers;
    ActorRef storage;

    public MainActor() {
        performers = getContext().actorOf(new RoundRobinPool(MAX_ROUND_ROBIN_POOL).props(Props.create(JSCodeExecutorActor.class)));
        storage = getContext().actorOf(Props.create(StorageActor.class));
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        PostMessage.class, pkt -> {
                            for (int i = 0; i < pkt.getTests().length; i++) {
                                performers.tell(new RunningMessage(new Pair<>(i, pkt)), storage);
                            }
                        }
                )
                .build();
    }
}
