package МilitaryElite.models.soldiers;

public abstract class Soldier {
    private int id;
    private String firstName;
    private String lastName;

    public Soldier(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d",firstName,lastName,id);
    }
}
