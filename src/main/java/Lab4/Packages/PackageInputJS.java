package Lab4.Packages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PackageInputJS {

    private final static String PACKAGE_ID = "packageId";
    private final static String JS_SCRIPT = "jsScript";
    private final static String FUNCTION_NAME = "functionName";
    private final static String Tests = "tests";

    private int packageId;
    private String jsScript;
    private String functionName;
    private Test[] tests;

    @JsonCreator
    public PackageInputJS(@JsonProperty(PACKAGE_ID) String packageId,
                          @JsonProperty(JS_SCRIPT) String jsScript,
                          @JsonProperty(FUNCTION_NAME) String functionName,
                          @JsonProperty(Tests) Test[] tests) {
        this.packageId = Integer.parseInt(packageId);
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public void setJsScript(String jsScript) {
        this.jsScript = jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public Test[] getTests() {
        return tests;
    }

    public void setTests(Test[] tests) {
        this.tests = tests;
    }
}


