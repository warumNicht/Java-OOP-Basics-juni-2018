package TheExpanse.models.colonistes;

public class GeneralPractitioner extends Medic {

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    protected int getPotentialBonuses() {
        return 0;
    }
}
