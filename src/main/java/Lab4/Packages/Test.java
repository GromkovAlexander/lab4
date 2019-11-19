package Lab4.Packages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;

public class Test {

    private final static String TEST_NAME = "packageId";
    private final static String EXPECTED_RESULTS = "jsScript";
    private final static String PARAMS = "functionName";

    private String testName;
    private String expectedResults;
    private Object[] params;

    @JsonCreator
    public Test(@JsonProperty(TEST_NAME) String testName,
                @JsonProperty(EXPECTED_RESULTS) String expectedResults,
                @JsonProperty(PARAMS) Object[] params) {
        this.testName = testName;
        this.expectedResults = expectedResults;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getExpectedResults() {
        return expectedResults;
    }

    public void setExpectedResults(String expectedResults) {
        this.expectedResults = expectedResults;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}


