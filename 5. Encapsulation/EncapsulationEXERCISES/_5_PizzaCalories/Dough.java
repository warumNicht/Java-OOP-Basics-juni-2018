package _5_PizzaCalories;

public class Dough {
    private String type;
    private String bakingTechnique;
    private double weight;

    public Dough(String type, String bakingTechnique, double weight) {
        setType(type);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setType(String type) {
        switch (type){
            case "White":
            case "Wholegrain":{
                this.type=type;
            }break;
            default:{
                throw new IllegalArgumentException("Invalid type of dough.");
            }
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique){
            case "Crispy":
            case "Chewy":
            case "Homemade":{
                this.bakingTechnique=bakingTechnique;
            }break;
            default:{
                throw new IllegalArgumentException("Invalid type of dough.");
            }
        }
    }

    private void setWeight(double weight) {
        if(weight<1||weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight=weight;

    }

    public double calculateCalories(){
        double teigCoef=1;
        double soseCoef=1;
        if(this.type.equals("White")){
            teigCoef=1.5;
        }

        if(this.bakingTechnique.equals("Crispy")){
            soseCoef=0.9;
        }else if(this.bakingTechnique.equals("Chewy")){
            soseCoef=1.1;
        }
        return 2*weight*teigCoef*soseCoef;
    }
}
