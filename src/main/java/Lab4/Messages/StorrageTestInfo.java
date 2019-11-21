package Lab4.Messages;

public class StorrageTestInfo {
    private final int packageId;
    private final TestInfo testInfo;

    public StorrageTestInfo(int packageId, TestInfo testInfo) {
        this.packageId = packageId;
        this.testInfo = testInfo;
    }

    public int getPackageId() {
        return packageId;
    }

    public TestInfo getTestInfo() {
        return testInfo;
    }
}
