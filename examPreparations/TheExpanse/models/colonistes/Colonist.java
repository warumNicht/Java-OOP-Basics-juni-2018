package TheExpanse.models.colonistes;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFamilyId() {
        return familyId;
    }

    public int getTalent() {
        return talent;
    }

    public int getAge() {
        return age;
    }

    public  int getPotential(){
        return this.talent+getPotentialBonuses();
    }
    abstract protected int getPotentialBonuses();
}
