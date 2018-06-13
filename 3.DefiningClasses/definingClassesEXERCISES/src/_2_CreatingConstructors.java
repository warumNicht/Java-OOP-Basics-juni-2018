import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class _2_CreatingConstructors {
    public static void main(String[] args)throws Exception  {

        InputStreamReader inpStr=new InputStreamReader(System.in);
        BufferedReader reader=new BufferedReader(inpStr);

        Class person=Person.class;

        Constructor emptyCtor=person.getDeclaredConstructor();
        Constructor ageCtor=person.getDeclaredConstructor(int.class);
        Constructor nameAgeCtor=person.getDeclaredConstructor(String.class,int.class);

        String name =reader.readLine();
        int age=Integer.parseInt(reader.readLine());

        Person basePerson=(Person) emptyCtor.newInstance();

        Person personWithAge=(Person) ageCtor.newInstance(age);

        Person fullPerson=(Person) nameAgeCtor.newInstance(name,age);

        System.out.printf("%s %s%n",basePerson.getName(),basePerson.getAge());
        System.out.printf("%s %s%n",personWithAge.getName(),personWithAge.getAge());
        System.out.printf("%s %s%n",fullPerson.getName(),fullPerson.getAge());

    }
}
class Person {
    private String name;
    private  int age;

    public Person() {
        this.name="No name";
        this.age=1;
    }

    public Person(int age) {
        this.name="No name";
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}