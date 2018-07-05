package МilitaryElite.interfaces;

import МilitaryElite.models.Mission;
import МilitaryElite.models.Repair;

import java.util.List;

public interface ICommando extends ISpecialisedSoldier {

    boolean validateMission(String str);

    List<Mission> getMissions();

    @Override
    boolean validateCorps(String input);

    @Override
    List<Repair> getRepairs();
}
