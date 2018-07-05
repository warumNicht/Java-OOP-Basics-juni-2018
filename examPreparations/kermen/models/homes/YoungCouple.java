package kermen.models.homes;

import kermen.models.Device;
import kermen.models.Person;

public class YoungCouple extends Home {
    private Person personTwo;

    public YoungCouple(double salary1,double salary2,double tvElectr,double fridgEl,double laptop1El) {
        super(salary1, 20*2);
        this.personTwo=new Person(salary2);
        super.getDevices().add(new Device(tvElectr));
        super.getDevices().add(new Device(fridgEl));
        super.getDevices().add(new Device(laptop1El*2));
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
