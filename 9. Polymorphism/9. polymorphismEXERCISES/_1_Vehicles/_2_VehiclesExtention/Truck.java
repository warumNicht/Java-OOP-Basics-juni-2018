package _2_VehiclesExtention;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(double fuel, double consumption, double tankCapacity) {
        setConsumption(consumption);
        setTankCapacity(tankCapacity);
        setFuel(fuel);

    }

    @Override
    protected void setConsumption(double consumption) {
        super.setConsumption(consumption+1.6);
    }
    @Override
    protected void drive(double distance) {
        double existingQuantity=this.getFuel();
        double neededQuantity=this.getConsumption()*distance;
        if(existingQuantity>=neededQuantity){
            DecimalFormat df=new DecimalFormat("#.##");
            System.out.printf("Truck travelled %s km%n",df.format(distance));
            this.deFuel(neededQuantity);
        }else{
            System.out.println("Truck needs refueling");
        }
    }

    @Override
    protected void reFuel(double fuel) {
        super.reFuel(fuel*0.95);
    }
}
