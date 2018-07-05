package SystemSplit.models.hardware;

public class PowerHardware extends BaseHardware {
    public PowerHardware(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
        super.setMaximumCapacity(maximumCapacity-(75*maximumCapacity)/100);
        super.setMaximumMemory(maximumMemory + (75*maximumMemory)/100);
    }
}
