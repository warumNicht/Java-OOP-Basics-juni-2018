package kermen.models;

import kermen.models.homes.Home;

import java.util.ArrayList;
import java.util.List;

public class City {

    private List<Home> homes;

    public City() {
        this.homes=new ArrayList<>();
    }

    public List<Home> getHomes() {
        return homes;
    }

    public void receiveSalary(){
        for (Home home : homes) {
            home.paySalary();
        }
    }
    public  void payEl(){
        for (Home home : homes) {
            home.billElectricity();
        }
    }
    public void actualize(){
        this.homes.removeIf(x->x.getBudget()<0);
    }
    public double totalConsumption(){
        double total=0;
        for (Home home : homes) {
            total+=home.calculateElectricity();
        }
        return total;
    }
    public int totalPopulation(){
        int sum=0;
        for (Home home : homes) {
            sum+=home.countMembers();
        }
        return sum;
    }
}
