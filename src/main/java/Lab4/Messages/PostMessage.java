package Lab4.Messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostMessage {

    private final static String PACKAGE_ID = "packageId";
    private final static String JS_SCRIPT = "jsScript";
    private final static String FUNCTION_NAME = "functionName";
    private final static String TESTS = "tests";

    private final int packageId;
    private final String jsScript;
    private final String functionName;
    private final Test[] tests;

    @JsonCreator
    public PostMessage(@JsonProperty(PACKAGE_ID) String packageId,
                       @JsonProperty(JS_SCRIPT) String jsScript,
                       @JsonProperty(FUNCTION_NAME) String functionName,
                       @JsonProperty(TESTS) Test[] tests) {
        this.packageId = Integer.parseInt(packageId);
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public int getPackageId() {
        return packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public Test[] getTests() {
        return tests;
    }
}


