package SystemSplit.models.software;

public abstract class BaseSoftware {
    private String name;
    private int capacityConsumption ;
    private int memoryConsumption;

    protected BaseSoftware(String name, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    public void setCapacityConsumption(int capacityConsumption) {
        this.capacityConsumption = capacityConsumption;
    }

    public void setMemoryConsumption(int memoryConsumption) {
        this.memoryConsumption = memoryConsumption;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    public String getName() {
        return name;
    }
}
