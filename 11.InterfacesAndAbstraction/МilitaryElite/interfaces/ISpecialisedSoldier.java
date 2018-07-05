package МilitaryElite.interfaces;

import МilitaryElite.models.Repair;

import java.util.List;

public interface ISpecialisedSoldier {
    boolean validateCorps(String input);
    List<Repair> getRepairs();

}
