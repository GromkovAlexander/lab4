package Lab4.Packages;

public class TestInfo {

    private final String res;
    private final String expectedRes;
    private boolean isCorrectAnswer;
    private final Object[] params;
    private final String testName;

    public TestInfo(String res, String expectedRes, boolean isCorrectAnswer, Object[] params, String testName) {
        this.res = res;
        this.expectedRes = expectedRes;
        this.isCorrectAnswer = isCorrectAnswer;
        this.params = params;
        this.testName = testName;
    }

    public String getRes() {
        return res;
    }

    public String getExpectedRes() {
        return expectedRes;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public Object[] getParams() {
        return params;
    }

    public String getTestName() {
        return testName;
    }
}
