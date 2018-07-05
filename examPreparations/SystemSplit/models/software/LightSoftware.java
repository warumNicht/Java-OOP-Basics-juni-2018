package SystemSplit.models.software;

public class LightSoftware extends BaseSoftware {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, capacityConsumption, memoryConsumption);
        super.setCapacityConsumption(capacityConsumption+capacityConsumption/2);
        super.setMemoryConsumption(memoryConsumption-memoryConsumption/2);
    }

}
