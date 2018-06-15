package _4_ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<String> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products=new ArrayList<>();
    }
    private void setName(String name) {
        name=name.replaceAll("\\s+","");
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");

        }else {
            this.name = name;
        }
    }
    private void setMoney(double money) {
        if(money<0){
            throw new IllegalArgumentException("Money cannot be negative");

        }else {
            this.money = money;
        }
    }
    public void byProduct(Product product){
        if(product.getCost()<=this.money){
            this.products.add(product.getName());
            this.money-=product.getCost();
            System.out.println(this.getName()+" bought "+product.getName());
        }else{
            System.out.println(this.name+" can't afford "+product.getName());
        }
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<String> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
