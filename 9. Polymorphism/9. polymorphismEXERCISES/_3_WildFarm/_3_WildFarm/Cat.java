package _3_WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eatFood(Food food) {
        this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
    }
    @Override
    public void print(){
        DecimalFormat df=new DecimalFormat("#.##");
        System.out.printf("%s[%s, %s, %s, %s, %d]%n",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                this.breed,
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten()
        );
    }

}
