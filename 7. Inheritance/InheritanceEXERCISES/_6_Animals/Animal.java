package _6_Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, String age) {
        setName(name);
        setAge(age);
    }

    public Animal(String name, String age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    protected void setName(String name) {
        if(name==null||name.trim().length()==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    protected void setAge(String ageStr) {
        int age;
        try {
            age=Integer.parseInt(ageStr);
        }catch (IllegalArgumentException er){
            throw new IllegalArgumentException("Invalid input!");
        }
        if(age<=0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    protected void setGender(String gender) {
        if(gender==null||gender.trim().length()==0||
                ("Female".equals(gender)==false&&"Male".equals(gender)==false)){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public void prouceSound(){
        System.out.println("Not implemented!");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +"\n"+name+" "+age+" "+gender;
    }
}
