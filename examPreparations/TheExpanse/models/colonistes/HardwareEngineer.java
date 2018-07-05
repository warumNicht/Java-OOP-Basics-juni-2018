package TheExpanse.models.colonistes;

public class HardwareEngineer extends Engineer {
    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }
    @Override
    protected int getPotentialBonuses() {
        return 0;
    }

}
