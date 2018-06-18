package _2_VehiclesExtention;

import java.text.DecimalFormat;

public class Bus extends Vehicle {

    public Bus(double fuel, double consumption, double tankCapacity) {
        setConsumption(consumption);
        setTankCapacity(tankCapacity);
        setFuel(fuel);

    }
    @Override
    public void setConsumption(double consumption) {
            super.setConsumption(consumption);
    }
    @Override
    protected void drive(double distance) {
        double existingQuantity=this.getFuel();
        double neededQuantity=this.getConsumption()*distance;
        if(existingQuantity>=neededQuantity){
            DecimalFormat df=new DecimalFormat("#.##");
            System.out.printf("Bus travelled %s km%n",df.format(distance));
            this.deFuel(neededQuantity);
        }else{
            System.out.println("Bus needs refueling");
        }
    }

}
