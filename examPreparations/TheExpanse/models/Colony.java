package TheExpanse.models;

import TheExpanse.models.colonistes.Colonist;

import java.util.ArrayList;
import java.util.List;

public class Colony {
    private final int maxFamilyCount;
    private final int maxFamilyCapacity;
    private List<Family> families;


    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families=new ArrayList<>();
    }

    public int getMaxFamilyCount() {
        return maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return maxFamilyCapacity;
    }

   List<Colonist> getColonistsByFamilyId(String familyId){
        return null;
   }
    public  int getPotential(){
        return 0;
    }

}
