package Lab4.Actors;

import Lab4.Packages.PackageInputJS;
import Lab4.Packages.RunningMessage;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javafx.util.Pair;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class JSCodeExecutorActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        RunningMessage.class, m -> {


                            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                            engine.eval(jscript);
                            Invocable invocable = (Invocable) engine;
                            return invocable.invokeFunction(functionName, params).toString();

                        }
                )
                .build();
    }
}
