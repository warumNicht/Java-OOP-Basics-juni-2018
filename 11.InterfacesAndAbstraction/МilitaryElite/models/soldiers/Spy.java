package МilitaryElite.models.soldiers;

public class Spy extends Soldier {
    private String codeNumber;

    public Spy(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s",super.toString(),
                String.format("Code Number: %s",codeNumber));
    }


}
