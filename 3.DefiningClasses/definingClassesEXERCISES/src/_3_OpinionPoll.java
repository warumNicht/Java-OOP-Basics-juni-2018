import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class _3_OpinionPoll {
    public static void main(String[] args)throws Exception  {

        InputStreamReader inpStr=new InputStreamReader(System.in);
        BufferedReader reader=new BufferedReader(inpStr);

        int n=Integer.parseInt(reader.readLine());
        List<Person> persons=new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] tokens=reader.readLine().split(" ");

            String curname=tokens[0];
            int curAge=Integer.parseInt(tokens[1]);
            persons.add(new Person(curname,curAge));

        }

        persons.stream()
                .filter(x->x.getAge()>30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(pers-> System.out.printf("%s - %d%n",pers.getName(),pers.getAge()));

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