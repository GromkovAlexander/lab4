package Lab4.Actors;

import Lab4.Packages.PackageInputJS;
import Lab4.Packages.StorrageCommand;
import Lab4.Packages.StorrageMessage;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class StorageActor extends AbstractActor {


    private Map<Integer, ArrayList<StorrageMessage>> storage = new Map<Integer, ArrayList<StorrageMessage>>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public ArrayList<StorrageMessage> get(Object key) {
            return null;
        }

        @Override
        public ArrayList<StorrageMessage> put(Integer key, ArrayList<StorrageMessage> value) {
            return null;
        }

        @Override
        public ArrayList<StorrageMessage> remove(Object key) {
            return null;
        }

        @Override
        public void putAll(Map<? extends Integer, ? extends ArrayList<StorrageMessage>> m) {

        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Integer> keySet() {
            return null;
        }

        @Override
        public Collection<ArrayList<StorrageMessage>> values() {
            return null;
        }

        @Override
        public Set<Entry<Integer, ArrayList<StorrageMessage>>> entrySet() {
            return null;
        }
    };

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        StorrageCommand.class, msg -> {
                            if (storage.containsKey(msg.getPackageId())) {

                            } else {

                            }

                        }
                )
                .build();
    }
}
