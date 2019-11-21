package Lab4.Packages;

public class StorrageCommand {
    private final int packageId;
    private final StorrageMessage storrageMessage;

    public StorrageCommand(int packageId, StorrageMessage storrageMessage) {
        this.packageId = packageId;
        this.storrageMessage = storrageMessage;
    }

    public int getPackageId() {
        return packageId;
    }

    public StorrageMessage getStorrageMessage() {
        return storrageMessage;
    }
}
