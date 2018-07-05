package МilitaryElite.models.soldiers.Privates;

public abstract class SpecialisedSoldier extends Private {
    private String corp;

    public SpecialisedSoldier(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.corp = corp;
    }

    protected String getCorp() {
        return corp;
    }
}
