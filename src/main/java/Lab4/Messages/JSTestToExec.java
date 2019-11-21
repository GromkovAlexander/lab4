package Lab4.Messages;

import javafx.util.Pair;

public class JSTestToExec {

    private final Pair<Integer, PostMessage> msg;

    public JSTestToExec(Pair<Integer, PostMessage> msg) {
        this.msg = msg;
    }

    public Pair<Integer, PostMessage> getMsg() {
        return msg;
    }
}
