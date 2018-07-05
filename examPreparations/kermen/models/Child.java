package kermen.models;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private double foodCost;
    private List<Toy> toys;
    private List<Double> depenses;

    public Child(List<Double> depenses) {
        this.depenses = depenses;
        this.toys=new ArrayList<>();
    }
    public double calcToys(){
        double sum=0;
        for (Double depens : depenses) {
            sum+=depens;
        }
        return sum;
    }
}
