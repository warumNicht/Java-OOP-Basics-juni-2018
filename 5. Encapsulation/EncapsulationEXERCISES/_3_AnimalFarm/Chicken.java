package _3_AnimalFarm;

public class Chicken {
    private String name;
    private int age;
    private double eggsPerDay;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
        setEggsPerDay();
    }

    @Override
    public String toString() {

        if(eggsPerDay>=1){
            return "Chicken "+name+" (age "+age+") can produce "+String.format("%.0f",eggsPerDay)+" eggs per day.";
        }else {
            return "Chicken "+name+" (age "+age+") can produce "+eggsPerDay+" eggs per day.";
        }

    }

    private void setName(String name) {
        String nameWithoutWhitespaces=name.replaceAll("\\s+","");
        if(name==null||name.length()<1||nameWithoutWhitespaces.length()<1){
            throw  new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = nameWithoutWhitespaces;
    }

    private void setAge(int age) {
        if(age<0||age>15){
            throw  new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setEggsPerDay() {
        if(age<6){
            this.eggsPerDay =2;
        }else  if(age>=6&&age<12){
            this.eggsPerDay =1;
        }else {
            this.eggsPerDay =0.75;
        }
    }
}
