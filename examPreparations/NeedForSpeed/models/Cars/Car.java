package NeedForSpeed.models.Cars;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower ;
    private int acceleration ;
    private int suspension ;
    private int durability ;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.setHorsepower(horsepower);
        this.acceleration = acceleration;
        this.setSuspension(suspension);
        this.durability = durability;
    }

    protected String getBrand() {
        return brand;
    }

    protected String getModel() {
        return model;
    }

    protected int getYearOfProduction() {
        return yearOfProduction;
    }

    protected int getHorsepower() {
        return horsepower;
    }

    protected int getAcceleration() {
        return acceleration;
    }

    protected int getSuspension() {
        return suspension;
    }

    protected int getDurability() {
        return durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    @Override
    public  String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("%s %s %d%n",this.getBrand(),this.getModel(),
                this.getYearOfProduction()))
                .append(String.format("%d HP, 100 m/h in %d s%n"),this.getHorsepower(),
                        this.getAcceleration())
                .append(String.format("%d Suspension force, %d Durability%n",
                        this.getSuspension(),this.getDurability()));

        return res.toString();

    };
}
