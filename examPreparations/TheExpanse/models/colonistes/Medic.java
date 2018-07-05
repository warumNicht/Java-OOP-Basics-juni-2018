package TheExpanse.models.colonistes;

public abstract class Medic extends Colonist {
    private String sign;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }


}
