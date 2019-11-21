package Lab4.Actors;

import Lab4.Packages.*;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class JSCodeExecutorActor extends AbstractActor {

    private String execJSCode(PostInput postInput, Test test) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval(postInput.getJsScript());
        Invocable invocable = (Invocable) engine;
        return invocable.invokeFunction(postInput.getFunctionName(), test.getParams()).toString();
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(
                        RunningMessage.class, m -> {

                            int index = m.getMsg().getKey();
                            PostInput postInput = m.getMsg().getValue();
                            Test test = postInput.getTests()[index];

                            String res = execJSCode(postInput, test);

                            boolean isCorrectAnswer = res.equals(test.getExpectedResults());

                            TestInfo testInfo = new TestInfo(
                                    res,
                                    test.getExpectedResults(),
                                    isCorrectAnswer,
                                    test.getParams(),
                                    test.getTestName()
                            );

                            StorrageTestInfo storrageTestInfo = new StorrageTestInfo(
                                    postInput.getPackageId(),
                                    testInfo
                            );

                            getSender().tell(storrageTestInfo, ActorRef.noSender());

                        }
                )
                .build();
    }
}
