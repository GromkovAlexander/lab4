package Lab4.Actors;

import Lab4.Packages.PackageInputJS;
import Lab4.Packages.RunningMessage;
import Lab4.Packages.Test;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javafx.util.Pair;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class JSCodeExecutorActor extends AbstractActor {

    private String execJSCode(PackageInputJS packageInputJS, Test test) {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(packageInputJS.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(packageInputJS.getFunctionName(), test.getParams()).toString();
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        RunningMessage.class, m -> {

                            int index = m.getMsg().getKey();
                            PackageInputJS packageInputJS = m.getMsg().getValue();
                            Test test = packageInputJS.getTests()[index];


                            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                            engine.eval(packageInputJS.getJsScript());
                            Invocable invocable = (Invocable) engine;
                            String res = invocable.invokeFunction(packageInputJS.getFunctionName(), test.getParams()).toString();

                        }
                )
                .build();
    }
}
