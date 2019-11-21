package Lab4.Actors;

import Lab4.Packages.StorrageTestInfo;
import Lab4.Packages.TestInfo;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.*;

public class StorageActor extends AbstractActor {


    private HashMap<Integer, ArrayList<TestInfo>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        StorrageTestInfo.class, msg -> {
                            if (storage.containsKey(msg.getPackageId())) {
                                ArrayList<TestInfo> tests = storage.get(msg.getPackageId());
                                tests.add(msg.getTestInfo());
                                storage.put(msg.getPackageId(), tests);
                            } else {
                                ArrayList<TestInfo> tests = new ArrayList<>();
                                tests.add(msg.getTestInfo());
                                storage.put(msg.getPackageId(), tests);
                            }
                        }
                )
                .build();
    }
}
