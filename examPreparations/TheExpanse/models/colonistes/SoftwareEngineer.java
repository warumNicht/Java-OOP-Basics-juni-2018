package TheExpanse.models.colonistes;

public class SoftwareEngineer extends Engineer {
    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getPotentialBonuses() {
        return 0;
    }
}
