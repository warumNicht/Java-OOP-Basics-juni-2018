package SystemSplit.models.software;

public class ExpressSoftware extends BaseSoftware {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
        this.setMemoryConsumption(memoryConsumption*2);
    }

}
