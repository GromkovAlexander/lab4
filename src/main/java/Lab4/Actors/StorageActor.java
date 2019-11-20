package Lab4.Actors;

import Lab4.Packages.PackageInputJS;
import Lab4.Packages.StorrageCommand;
import Lab4.Packages.StorrageMessage;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.*;

public class StorageActor extends AbstractActor {


    private HashMap<Integer, ArrayList<StorrageMessage>> storage = new Map<Integer, ArrayList<StorrageMessage>>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        StorrageCommand.class, msg -> {
                            if (storage.containsKey(msg.getPackageId())) {
                                ArrayList<StorrageMessage> tests = storage.get(msg.getPackageId());
                                tests.add(msg.getStorrageMessage());
                                storage.put(msg.getPackageId(), tests);
                            } else {
                                ArrayList<StorrageMessage> tests = new ArrayList<>();
                                tests.add(msg.getStorrageMessage());
                                storage.put(msg.getPackageId(), tests);
                            }
                        }
                )
                .build();
    }
}
