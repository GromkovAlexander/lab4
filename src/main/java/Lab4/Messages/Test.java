package Lab4.Packages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {

    private final static String TEST_NAME = "testName";
    private final static String EXPECTED_RESULTS = "expectedResult";
    private final static String PARAMS = "params";

    private final String testName;
    private final String expectedResults;
    private final Object[] params;

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

    public String getExpectedResults() {
        return expectedResults;
    }

    public Object[] getParams() {
        return params;
    }
}


