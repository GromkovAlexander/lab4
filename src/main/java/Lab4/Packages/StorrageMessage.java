package Lab4.Packages;

public class StorrageMessage {

    private int packageId;
    private String res;
    private String expectedRes;
    private boolean isCorrectAnswer;
    private Object[] params;
    private String testName;

    public StorrageMessage(int packageId, String res, String expectedRes, boolean isCorrectAnswer, Object[] params, String testName) {
        this.packageId = packageId;
        this.res = res;
        this.expectedRes = expectedRes;
        this.isCorrectAnswer = isCorrectAnswer;
        this.params = params;
        this.testName = testName;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getExpectedRes() {
        return expectedRes;
    }

    public void setExpectedRes(String expectedRes) {
        this.expectedRes = expectedRes;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        isCorrectAnswer = correctAnswer;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
