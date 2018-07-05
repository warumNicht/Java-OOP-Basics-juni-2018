package SystemSplit.models.hardware;

public class HeavyHardware extends BaseHardware {
    public HeavyHardware(String name, String type, int maximumCapacity, int maximumMemory) {
        super(name, type, maximumCapacity, maximumMemory);
        super.setMaximumMemory(maximumMemory-(25*maximumMemory)/100);
        super.setMaximumCapacity(maximumCapacity*2);
    }
}
