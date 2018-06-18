package _1_Vehicles;

public  class Vehicle {
    private double fuel;
    private double consumption;

    public Vehicle() {

    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    protected void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    protected  void drive(double distance){

    };

    protected double getFuel() {
        return fuel;
    }

    protected double getConsumption() {
        return consumption;
    }
    protected void reFuel(double fuel){
        this.fuel+=fuel;
    }
    protected void deFuel(double fuel){
        this.fuel-=fuel;
    }
}
