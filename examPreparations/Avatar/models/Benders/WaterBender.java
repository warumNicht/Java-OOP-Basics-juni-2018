package Avatar.models.Benders;

public class WaterBender extends Bender {
    private double waterClarity;

    public WaterBender(String name, int power, double waterClarity) {
        super(name, power);
        this.waterClarity = waterClarity;
    }
    @Override
    public double calculatePower() {
        return this.waterClarity*super.getPower();
    }
    @Override
    public String toString() {
        return String.format("###Water Bender: %s, Power: %d, Water Clarity: %.2f%n",
                this.getName(),this.getPower(),waterClarity);
    }
}
