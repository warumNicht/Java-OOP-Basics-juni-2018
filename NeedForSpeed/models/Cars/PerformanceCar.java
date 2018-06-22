package NeedForSpeed.models.Cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {
    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns=new ArrayList<>();
    }

    @Override
    protected void setHorsepower(int horsepower) {
        int increaseHorsepower=horsepower+(horsepower*50)/100;
        super.setHorsepower(increaseHorsepower);
    }

    @Override
    protected void setSuspension(int suspension) {
        int decreaseSuspension=suspension-(suspension*25)/100;
        super.setSuspension(decreaseSuspension);
    }


    protected List<String> getAddOns() {
        return addOns;
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder(super.toString());
        if (this.addOns.isEmpty()){
            res.append("Add-ons: None\n");
        }else {
            res.append("Add-ons: ")
                    .append(String.join(", ",this.addOns))
                    .append(System.lineSeparator());
        }
        return res.toString();
    }
}
