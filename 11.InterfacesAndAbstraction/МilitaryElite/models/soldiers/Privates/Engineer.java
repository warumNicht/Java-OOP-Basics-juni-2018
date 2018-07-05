package МilitaryElite.models.soldiers.Privates;

import МilitaryElite.interfaces.ISpecialisedSoldier;
import МilitaryElite.models.Repair;

import java.util.ArrayList;
import java.util.List;

public class Engineer extends SpecialisedSoldier implements ISpecialisedSoldier {
    private List<Repair> repairs;

    public Engineer(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.repairs=new ArrayList<>();
    }

    @Override
    public boolean validateCorps(String input) {

        if(input.equals("Marines")||input.equals("Airforces")){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Repair> getRepairs() {
        return repairs;
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(System.lineSeparator()).append(String.format("Corps: %s%n",super.getCorp()));
        for (Repair repair : repairs) {
            res.append(repair.toString()).append(System.lineSeparator());
        }
        return res.toString();
    }
}
