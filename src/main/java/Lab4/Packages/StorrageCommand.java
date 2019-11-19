package Lab4.Packages;

public class StorrageCommand {
    private int packageId;
    private StorrageMessage storrageMessage;

    public StorrageCommand(int packageId, StorrageMessage storrageMessage) {
        this.packageId = packageId;
        this.storrageMessage = storrageMessage;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public StorrageMessage getStorrageMessage() {
        return storrageMessage;
    }

    public void setStorrageMessage(StorrageMessage storrageMessage) {
        this.storrageMessage = storrageMessage;
    }
}
