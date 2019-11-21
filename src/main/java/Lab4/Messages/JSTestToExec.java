package Lab4.Messages;

import javafx.util.Pair;

public class RunningMessage {

    private final Pair<Integer, PostMessage> msg;

    public RunningMessage(Pair<Integer, PostMessage> msg) {
        this.msg = msg;
    }

    public Pair<Integer, PostMessage> getMsg() {
        return msg;
    }
}
