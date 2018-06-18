package _3_WildFarm;

public class Tiger extends Felime {
    public Tiger(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eatFood(Food food) {
        if(food.getClass().getSimpleName().equals("Meat")){
            this.setFoodEaten(this.getFoodEaten()+food.getQuantity());
        }else {
            System.out.printf("%ss are not eating that type of food!%n",this.getClass().getSimpleName());
        }
    }
}
