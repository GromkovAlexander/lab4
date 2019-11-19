package Lab4.Actors;

import Lab4.Packages.PackageInputJS;
import Lab4.Packages.StorrageMessage;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.Map;

public class StorageActor extends AbstractActor {

    private Map<Integer, PackageInputJS> storage = new Map<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        StorrageMessage.class, msg -> {

                        }
                )
                .build();
    }
}
