package FirstAndReserveTeam;

public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;

    public Person(String firstName, String lastName, Integer age, Double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    private void setSalary(Double salary) {
        if(salary<460){
            throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }
        this.salary = salary;
    }

    private void setFirstName(String firstName) {
        if(firstName.length()<3){
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(lastName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    private void setAge(Integer age) {
        if(age<=0){
            throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }
    public void increaseSalary(Double bonus){
        if(this.age>30){
            this.salary+=this.salary*bonus/100;
        }else {
            this.salary+=this.salary*bonus/200;
        }
    }

    @Override
    public String toString() {
        return this.firstName+" "+this.lastName+" gets "+this.salary+" leva";
    }
}
