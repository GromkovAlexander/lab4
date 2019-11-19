package Lab4.Actors;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;

public class MainActor extends AbstractActor {

    ActorRef performers;
    ActorRef storage;

    public MainActor() {

    }

    @Override
    public Receive createReceive() {
        return null;
    }
}
