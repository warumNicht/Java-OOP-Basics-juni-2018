package _6_Animals;

public class Cat extends Animal {
    public Cat(String name, String age) {
        super(name, age);
    }

    public Cat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void prouceSound() {
        System.out.println("MiauMiau");
    }
}
