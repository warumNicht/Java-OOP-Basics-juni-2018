package NeedForSpeed.models.Cars;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars =0;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        res.append(String.format("%d *%n",this.stars));

        return res.toString();
    }
}
