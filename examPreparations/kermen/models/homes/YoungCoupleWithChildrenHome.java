package kermen.models.homes;

import kermen.models.Child;
import kermen.models.Device;
import kermen.models.Person;

import java.util.ArrayList;
import java.util.List;

public class YoungCoupleWithChildrenHome extends Home {
    private Person personTwo;
    private List<Child> children;
    public YoungCoupleWithChildrenHome(double salary1,double salary2,double tvElectr,double fridgEl,double laptop1El) {
        super(salary1, 30*2);
        this.personTwo=new Person(salary2);
        super.getDevices().add(new Device(tvElectr));
        super.getDevices().add(new Device(fridgEl));
        super.getDevices().add(new Device(laptop1El*2));
        this.children=new ArrayList<>();
    }
    @Override
    public void paySalary() {
        super.setBudget(super.getBudget()+super.getPersonOne().getSalary()+this.personTwo.getSalary());
    }

    public List<Child> getChildren() {
        return children;
    }
    @Override
    public int countMembers() {
        return 2+this.children.size();
    }
    @Override
    public void billElectricity() {
        super.setBudget(super.getBudget()-this.calculateElectricity());
    }

    @Override
    public double calculateElectricity() {
        return super.getRoomOne().getEnergyConsumption()+super.calcDevicesEnergy()+this.calcChildrenDepenses();
    }
    private double calcChildrenDepenses(){
        double sum=0;
        for (Child child : children) {
            sum+=child.calcToys();
        }
        return sum;
    }
}
