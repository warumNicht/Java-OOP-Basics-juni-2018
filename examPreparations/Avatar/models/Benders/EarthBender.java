package Avatar.models.Benders;

public class EarthBender extends Bender {
    private double groundSaturation;

    public EarthBender(String name, int power, double groundSaturation) {
        super(name, power);
        this.groundSaturation = groundSaturation;
    }
    @Override
    public double calculatePower() {
        return this.groundSaturation*super.getPower();
    }
    @Override
    public String toString() {
        return String.format("###Earth Bender: %s, Power: %d, Ground Saturation: %.2f%n",
                this.getName(),this.getPower(),groundSaturation);
    }
}
