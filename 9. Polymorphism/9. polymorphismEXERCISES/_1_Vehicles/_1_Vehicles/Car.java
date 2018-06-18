package _1_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuel, double consumption) {
        setConsumption(consumption);
        setFuel(fuel);
    }

    @Override
    protected void setFuel(double fuel) {
        super.setFuel(fuel);
    }

    @Override
    protected void setConsumption(double consumption) {
        super.setConsumption(consumption+0.9);
    }

    @Override
    protected void drive(double distance) {
        double existingQuantity=this.getFuel();
        double neededQuantity=this.getConsumption()*distance;
        if(existingQuantity>=neededQuantity){
            DecimalFormat df=new DecimalFormat("#.##");
            System.out.printf("Car travelled %s km%n",df.format(distance));
            this.deFuel(neededQuantity);
        }else{
            System.out.println("Car needs refueling");
        }
    }


}
