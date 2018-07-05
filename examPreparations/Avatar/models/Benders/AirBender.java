package Avatar.models.Benders;

public class AirBender extends Bender {
    private double aerialIntegirty;

    public AirBender(String name, int power, double aerialIntegirty) {
        super(name, power);
        this.aerialIntegirty = aerialIntegirty;
    }

    @Override
    public double calculatePower() {
        return this.aerialIntegirty*super.getPower();
    }

    @Override
    public String toString() {
        return String.format("###Air Bender: %s, Power: %d, Aerial Integrity: %.2f%n",
                this.getName(),this.getPower(),aerialIntegirty);
    }
}
