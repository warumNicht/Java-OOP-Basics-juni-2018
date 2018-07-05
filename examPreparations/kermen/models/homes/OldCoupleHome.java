package kermen.models.homes;

import kermen.models.Device;
import kermen.models.Person;

public class OldCoupleHome extends Home {
    private Person personTwo;
    public OldCoupleHome(double salary,double salary2,double tvElectr,double fridgEl,double stoveEl) {
        super(salary, 15*3);
        this.personTwo=new Person(salary2);
        super.getDevices().add(new Device(tvElectr));
        super.getDevices().add(new Device(fridgEl));
        super.getDevices().add(new Device(stoveEl));
    }
    @Override
    public void paySalary() {
        super.setBudget(super.getBudget()+super.getPersonOne().getSalary()+this.personTwo.getSalary());
    }

    @Override
    public int countMembers() {
        return 2;
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
