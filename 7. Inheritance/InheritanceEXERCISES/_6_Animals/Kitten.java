package _6_Animals;

public class Kitten extends Cat {
    public Kitten(String name, String age,String gender) {
        super(name, age);
        setKittenGender(gender);
    }

    private  void setKittenGender(String gender) {
        if(gender.equals("Male")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.setGender(gender);
    }


    @Override
    public void prouceSound() {
        System.out.println("Miau");
    }
}
