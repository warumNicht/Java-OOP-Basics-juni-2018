package _6_Animals;

public class Tomcat extends Cat {
    public Tomcat(String name, String age,String gender) {
        super(name, age);
        setTomGender(gender);
    }
    private  void setTomGender(String gender) {
        if(gender.equals("Female")){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.setGender(gender);
    }

    @Override
    public void prouceSound() {
        System.out.println("Give me one million b***h");
    }
}
