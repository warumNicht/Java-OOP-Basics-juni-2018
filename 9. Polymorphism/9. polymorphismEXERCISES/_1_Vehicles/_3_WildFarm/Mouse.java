package _3_WildFarm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {
        if(food.getClass().getSimpleName().equals("Vegetable")){
            this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
        }else {
            System.out.println("Mice are not eating that type of food!");
        }
    }
}
