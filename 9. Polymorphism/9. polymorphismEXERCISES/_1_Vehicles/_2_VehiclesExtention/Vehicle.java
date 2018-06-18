package _2_VehiclesExtention;

public  class Vehicle {
    private double fuel;
    private double consumption;
    private double tankCapacity;

    public Vehicle() {
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void setFuel(double fuel) {
        if(fuel<=0){
            System.out.println("Fuel must be a positive number");
        }else {
            if(this.tankCapacity-this.fuel<=fuel){
                System.out.println("Cannot fit fuel in tank");
            }else {
                this.fuel+=fuel;
            }

        }
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
        if(fuel<=0){
            System.out.println("Fuel must be a positive number");
        }else {
            if(this.tankCapacity-this.fuel<=fuel){
                System.out.println("Cannot fit fuel in tank");
            }else {
                this.fuel+=fuel;
            }

        }
    }
    protected void deFuel(double fuel){
        this.fuel-=fuel;
    }
}
