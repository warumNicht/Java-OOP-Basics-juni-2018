package _1_Person;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    protected void setName(String name) {
        if(name==null||name.length()<3){
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    protected void setAge(int age) {
        if(age<1){
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    @Override
    public String toString() {
        final StringBuilder res=new StringBuilder();
        res.append(String.format("Name: %s, Age: %d",
                this.getName(),this.getAge()
        ));
        return res.toString();
    }
}
