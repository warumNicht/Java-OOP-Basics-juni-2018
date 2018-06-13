import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _4_CompanyRoster {
    public static void main(String[] args)throws Exception  {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        LinkedHashMap<String,List<Employee>> depts=new LinkedHashMap<>();

        for(int i=0; i<n; i++){
            String input=reader.readLine();

            String[] tokens=input.split("\\s+");

                String curName=tokens[0];
                double curSal=Double.parseDouble(tokens[1]);
                String curPos=tokens[2];
                String curDep=tokens[3];
                Employee curEmp=new Employee(curName,curSal,curPos,curDep);

                if(tokens.length==5){
                    if(tokens[4].contains("@")) {
                        curEmp.setEmail(tokens[4]);
                    }else {
                        curEmp.setAge(Integer.parseInt(tokens[4]));
                    }

                }else if(tokens.length==6){
                    curEmp.setEmail(tokens[4]);
                    curEmp.setAge(Integer.parseInt(tokens[5]));
                }

                if(depts.containsKey(curEmp.getDepartement())==false){
                    depts.put(curEmp.getDepartement(),new ArrayList<>());
                }
                depts.get(curEmp.getDepartement()).add(curEmp);
        }

        depts.entrySet().stream()
                .sorted((x,y)->{

                    double xAver=x.getValue().stream()
                            .mapToDouble(s->s.getSalary())
                            .average().getAsDouble();

                    double yAver=y.getValue().stream()
                            .mapToDouble(s->s.getSalary())
                            .average().getAsDouble();

                    return Double.compare(yAver,xAver);
                })
                .limit(1)
                .forEach(kv->{
                    System.out.printf("Highest Average Salary: %s%n",kv.getKey());
                    kv.getValue().stream()
                            .sorted((a,b)->{
                                return Double.compare(b.getSalary(),a.getSalary());
                            })
                            .forEach(emp->{
                                System.out.printf("%s %.2f %s %d%n",
                                        emp.getName(),emp.getSalary(),emp.getEmail(),emp.getAge());
                            });
                });

    }
}
class Departement{
    String name;
    List<Employee> employees;

    public Departement(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
class Employee{
    String name;
    double salary;
    String position;
    String departement;
    String email;
    int age;



    public Employee(String name, double salary, String position, String departement) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.departement = departement;
        this.email="n/a";
        this.age = -1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}