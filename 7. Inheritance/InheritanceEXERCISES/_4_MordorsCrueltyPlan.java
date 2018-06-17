import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4_MordorsCrueltyPlan {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        GandalfTheGray wizard=new GandalfTheGray(input);

        System.out.println(wizard.getFoodEaten());
        System.out.println(wizard.getMood());

    }
}

class GandalfTheGray{
    private int foodEaten;
    private String mood;

    public GandalfTheGray(String foodEaten) {
        this.setFoodEaten(foodEaten);
        this.setMood(this.foodEaten);
    }

    private void setFoodEaten(String foodEaten) {
        String[] food=foodEaten.split("\\s+");
        int sum=0;
        for (String s : food) {
            sum+=calculateFoodPoints(s);
        }
        this.foodEaten=sum;
    }

    private void setMood(int foodEaten) {
        if(foodEaten<-5){
            this.mood="Angry";
        }else if(foodEaten<=0){
            this.mood="Sad";
        }else if(foodEaten<=15){
            this.mood="Happy";
        }else {
            this.mood="JavaScript";
        }
    }

    private  int calculateFoodPoints(String food){
        int res=0;
        switch (food.toLowerCase()){
            case "cram": res=2;
                break;
            case "lembas": res=3;
                break;
            case "apple": res=1;
                break;
            case "melon": res=1;
                break;
            case "honeycake": res=5;
                break;
            case "mushrooms": res=-10;
                break;
                default:res=-1;
        }
        return res;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public String getMood() {
        return mood;
    }
}
