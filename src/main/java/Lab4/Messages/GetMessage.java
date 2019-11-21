package Lab4.Messages;

public class GetMessage {
    private final int packageId;

    public GetMessage(int packageId) {
        this.packageId = packageId;
    }

    public int getPackageId() {
        return packageId;
    }
}
