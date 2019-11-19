package Lab4.Packages;

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

    public PackageInputJS(@JsonProperty(PACKAGE_ID) String packageId,
                          @JsonProperty(JS_SCRIPT) String jsScript,
                          @JsonProperty(FUNCTION_NAME) String functionName,
                          @JsonProperty(Tests) Test[] tests) {

    }


    


}


