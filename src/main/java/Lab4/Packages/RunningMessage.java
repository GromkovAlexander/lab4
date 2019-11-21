package Lab4.Packages;

import javafx.util.Pair;

public class RunningMessage {

    private final Pair<Integer, PostInput> msg;

    public RunningMessage(Pair<Integer, PostInput> msg) {
        this.msg = msg;
    }

    public Pair<Integer, PostInput> getMsg() {
        return msg;
    }
}
