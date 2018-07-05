package kermen.models.homes;

public class AloneOldHome extends Home {
    public AloneOldHome( double salary) {
        super( salary, 15);
    }

    @Override
    public void paySalary() {
        super.setBudget(super.getBudget()+super.getPersonOne().getSalary());
    }

    @Override
    public int countMembers() {
        return 1;
    }

    @Override
    public void billElectricity() {
        super.setBudget(super.getBudget()-this.calculateElectricity());
    }

    @Override
    public double calculateElectricity() {
        return super.getRoomOne().getEnergyConsumption();
    }
}
