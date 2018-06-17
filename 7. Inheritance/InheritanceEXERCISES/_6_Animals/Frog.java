package _6_Animals;

public class Frog extends Animal {
    public Frog(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void prouceSound() {
        System.out.println("Frogggg");
    }
}
