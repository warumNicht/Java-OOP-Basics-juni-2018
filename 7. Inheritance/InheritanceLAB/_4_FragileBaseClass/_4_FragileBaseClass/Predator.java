package _4_FragileBaseClass;

public class Predator extends Animal{
    private int health;

    public Predator(int health) {
        super();
        this.health = health;
    }

    public  void feed(Food food){
        super.eat(food);
        health++;
    }
}
