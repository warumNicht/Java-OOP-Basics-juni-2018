package _5_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private int toppingNumber;
    private List<Topping> toppings;

    public Pizza(String name, int toppingNumber) {
        setName(name);
        this.dough = null;
        setToppingNumber(toppingNumber);
        toppings=new ArrayList<>();
    }

    private void setName(String name) {
        name=name.replaceAll("\\s\\s+","");
        if(name.isEmpty()||name.length()>15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppingNumber(int toppingNumber) {
        if(toppingNumber<0||toppingNumber>15){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppingNumber=toppingNumber;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public Dough getDough() {
        return dough;
    }

    public String getName() {
        return name;
    }
}
