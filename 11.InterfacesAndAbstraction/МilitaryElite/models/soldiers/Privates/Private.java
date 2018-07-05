package МilitaryElite.models.soldiers.Privates;

import МilitaryElite.models.soldiers.Soldier;

public class Private extends Soldier {
    private double salary;

    public Private(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }
    @Override
    public String toString() {
        return String.format("%s Salary: %.2f",super.toString(),salary);
    }
}
