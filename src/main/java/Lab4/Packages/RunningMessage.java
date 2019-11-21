package Lab4.Packages;

import javafx.util.Pair;

public class RunningMessage {

    private final Pair<Integer, PackageInputJS> msg;

    public RunningMessage(Pair<Integer, PackageInputJS> msg) {
        this.msg = msg;
    }

    public Pair<Integer, PackageInputJS> getMsg() {
        return msg;
    }
}
