package kermen.models.homes;

import kermen.models.Device;

public class AloneYoungHome extends Home {
    public AloneYoungHome( double salary,double laptopElectr) {
        super( salary, 10);
        super.getDevices().add(new Device(laptopElectr));
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
        return super.getRoomOne().getEnergyConsumption()+super.calcDevicesEnergy();
    }
}
