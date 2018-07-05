package kermen.models.homes;

import kermen.models.Device;
import kermen.models.Person;
import kermen.models.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Home {
    private double budget;
    private Person personOne;
    private Room roomOne;
    private List<Device> devices;

    public Home( double salary, double energyConsumption) {
        this.personOne = new Person(salary);
        this.roomOne = new Room(energyConsumption);
        this.devices=new ArrayList<>();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public Room getRoomOne() {
        return roomOne;
    }

    public double getBudget() {
        return budget;
    }

    public Person getPersonOne() {
        return personOne;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    public double calcDevicesEnergy(){
        double sum=0;
        for (Device device : devices) {
            sum+=device.getEnergyConsunption();
        }
        return sum;
    }

    public abstract void paySalary();

    public abstract int countMembers();

    public abstract void billElectricity();

    public abstract double calculateElectricity();

}
