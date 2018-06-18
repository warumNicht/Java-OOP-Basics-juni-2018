package _3_WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
    @Override
    public void eatFood(Food food) {
        if(food.getClass().getSimpleName().equals("Vegetable")){
            this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
        }else {
            System.out.printf("%ss are not eating that type of food!%n",this.getClass().getSimpleName());
        }
    }
}
