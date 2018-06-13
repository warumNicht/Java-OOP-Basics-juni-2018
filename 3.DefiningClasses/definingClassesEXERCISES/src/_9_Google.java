import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _9_Google {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> persons=new ArrayList<>();

        String input=reader.readLine();

        while ("End".equals(input)==false){
            String[] tokens=input.split("\\s+");
            String curName=tokens[0];

            boolean existCurPerson=persons.stream()
                    .anyMatch(p->p.name.equals(curName));
            if(existCurPerson==false){
                persons.add(new Person(curName));
            }
            List<Person> curPersons=persons.stream().filter(x->x.name.equals(curName)).collect(Collectors.toList());

            Person currUser=curPersons.get(0);

            if(tokens.length==5){
                String compName=tokens[2];
                String departement=tokens[3];
                double curSalary=Double.parseDouble(tokens[4]);

                currUser.setCompany(new Company(compName,departement,curSalary));
            }else{

                switch (tokens[1]){

                    case "pokemon":{
                        String pokName=tokens[2];
                        String pokType=tokens[3];
                        boolean containsPokem=currUser.pokemons.stream()
                                .anyMatch(p->p.name.equals(pokName)&&p.type.equals(pokType));
                        if(containsPokem==false){
                            currUser.pokemons.add(new Pokem(pokName,pokType));
                        }
                    }break;
                    case "parents":{
                        String parName=tokens[2];
                        String parBirthday=tokens[3];
                        boolean containsPar=currUser.parents.stream()
                                .anyMatch(p->p.name.equals(parName)&&p.birthay.equals(parBirthday));
                        if(containsPar==false){
                            currUser.parents.add(new Parent(parName,parBirthday));
                        }
                    }break;
                    case "children":{
                        String chName=tokens[2];
                        String chBirthday=tokens[3];

                        boolean containsCh=currUser.children.stream()
                                .anyMatch(p->p.name.equals(chName)&&p.birthay.equals(chBirthday));

                        if(containsCh==false){
                            currUser.children.add(new Child(chName,chBirthday));
                        }
                    }break;
                    case "car":{
                        String curCar=tokens[2]+" "+tokens[3];
                        currUser.setCar(curCar);
                    }break;

                }
            }
            input=reader.readLine();
        }

        input=reader.readLine();
        String wantedPerson=input;
        persons.stream()
                .filter(p->p.name.equals(wantedPerson))
                .forEach(x->{
                    System.out.println(x.name);
                    System.out.println("Company:");
                    if(x.company!=null){
                        System.out.printf("%s %s %.2f%n",x.company.name
                        ,x.company.departement,x.company.salary);
                    }
                    System.out.println("Car:");
                    if(x.car.equals("")==false){
                        System.out.printf("%s%n",x.car);
                    }

                    System.out.println("Pokemon:");
                        x.pokemons.stream()
                                .forEach(pok-> System.out.printf("%s %s%n",pok.name,pok.type));


                    System.out.println("Parents:");
                        x.parents.stream()
                                .forEach(p-> System.out.printf("%s %s%n",p.name,p.birthay));


                    System.out.println("Children:");
                    x.children.stream()
                            .forEach(ch-> System.out.printf("%s %s%n",ch.name,ch.birthay));


                });

    }
}

class Person{
    String name;
    String car;
    Company company;
    List<Pokem> pokemons;
    List<Child> children;
    List<Parent> parents;

    public Person(String name) {
        this.name = name;
        this.car="";
        this.pokemons=new ArrayList<>();
        this.children=new ArrayList<>();
        this.parents=new ArrayList<>();

    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
class Company{
    String name;
    String departement;
    double salary;

    public Company(String name, String departement, double salary) {
        this.name = name;
        this.departement = departement;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
class Child{
    String name;
    String birthay;

    public Child(String name, String birthay) {
        this.name = name;
        this.birthay = birthay;
    }

    public String getName() {
        return name;
    }

    public String getBirthay() {
        return birthay;
    }
}
class Parent{
    String name;
    String birthay;

    public Parent(String name, String birthay) {
        this.name = name;
        this.birthay = birthay;
    }

    public String getName() {
        return name;
    }

    public String getBirthay() {
        return birthay;
    }
}
class Pokem{
    String name;
    String type;

    public Pokem(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
