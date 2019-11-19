package Lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.routing.RoundRobinPool;

public class MainActor extends AbstractActor {

    ActorRef performers;
    ActorRef storage;

    public MainActor() {

        performers = getContext().actorOf(
                new RoundRobinPool(5)
                        .withSupervisorStrategy(strategy)
                        .props(Props.create(TestPerformerActor.class, logResultsActor)),
                "routerForTests"
        );
    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
