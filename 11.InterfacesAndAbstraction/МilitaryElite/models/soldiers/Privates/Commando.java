package МilitaryElite.models.soldiers.Privates;

import МilitaryElite.interfaces.ICommando;
import МilitaryElite.models.Mission;
import МilitaryElite.models.Repair;

import java.util.ArrayList;
import java.util.List;

public class Commando extends SpecialisedSoldier implements ICommando {
    private List<Mission> missions;

    public Commando(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary, corp);
        this.missions=new ArrayList<>();
    }

    @Override
    public boolean validateMission(String str) {
        if(str.equals("inProgress")||str.equals("Finished")){
            return true;
        }else {
            return false;
        }
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
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(System.lineSeparator())
                .append(String.format("Corps: %s%n",super.getCorp()))
                .append("Missions:\n");
        for (Mission mission : missions) {
            res.append(mission.toString()).append(System.lineSeparator());
        }
        return res.toString();
    }

    @Override
    public List<Mission> getMissions() {
        return missions;
    }

    @Override
    public List<Repair> getRepairs() {
        return null;
    }
}
