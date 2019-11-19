package Lab4.Actors;

import Lab4.Packages.PackageInputJS;
import Lab4.Packages.RunningMessage;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javafx.util.Pair;


public class JSCodeExecutorActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        RunningMessage.class, m -> {
                            
                        }
                )
                .build();
    }
}
