package _5_PizzaCalories;

public class Topping {
    private String type;
    private double weight;

    public Topping(String type, double weight) {
        setType(type);
        setWeight(weight);
    }

    private void setType(String type) {
        switch (type){
            case "Meat":
            case "Sauce":
            case "Veggies":
            case "Cheese":{
                this.type=type;
            }break;
            default:{
                throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.%n",type));
            }
        }
    }

    private void setWeight(double weight) {
        if(weight<1||weight>50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].%n",type));
        }
        this.weight=weight;
    }
    public double calculateToppingCal(){
        double toppingCoef=1;

        switch (this.type){
            case "Meat":{
                toppingCoef=1.2;
            }break;
            case "Veggies":{
                toppingCoef=0.8;
            }break;
            case "Cheese":{
                toppingCoef=1.1;
            }break;
            case "Sauce":{
                toppingCoef=0.9;
            }break;
        }
        return 2*weight*toppingCoef;
    }
}
