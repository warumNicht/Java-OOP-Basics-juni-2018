package Avatar.models.Benders;

public abstract class Bender {
    private String name;
    private int power;

    protected Bender(String name, int power) {
        this.name = name;
        this.power = power;
    }

    protected String getName() {
        return name;
    }

    protected int getPower() {
        return power;
    }

    public abstract double calculatePower();

    @Override
    public abstract String toString();
}
