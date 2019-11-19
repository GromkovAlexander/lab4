package Lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.RoundRobinPool;

public class MainActor extends AbstractActor {

    private final static int MAX_ROUND_ROBIN_POOL = 5;

    ActorRef performers;
    ActorRef storage;

    public MainActor() {
        performers = getContext().actorOf(new RoundRobinPool(MAX_ROUND_ROBIN_POOL).props(Props.create(JSCodeExecutorActor.class)));
        storage = getContext().actorOf(Props.create())
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
