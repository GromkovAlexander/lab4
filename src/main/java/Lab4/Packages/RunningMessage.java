package Lab4.Packages;

import javafx.util.Pair;

public class RunningMessage {

    private Pair<Integer, PackageInputJS> msg;

    public RunningMessage(Pair<Integer, PackageInputJS> msg) {
        this.msg = msg;
    }

    public Pair<Integer, PackageInputJS> getMsg() {
        return msg;
    }

    public void setMsg(Pair<Integer, PackageInputJS> msg) {
        this.msg = msg;
    }
}
