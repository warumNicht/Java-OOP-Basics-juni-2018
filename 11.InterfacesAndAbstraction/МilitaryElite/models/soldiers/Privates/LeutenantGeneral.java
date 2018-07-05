package МilitaryElite.models.soldiers.Privates;

import java.util.ArrayList;
import java.util.List;

public class LeutenantGeneral extends Private {
    private List<Integer> privates;

    public LeutenantGeneral(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates=new ArrayList<>();
    }

    public List<Integer> getPrivates() {
        return privates;
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(System.lineSeparator()).append("Privates:");
        return res.toString();
    }
}
