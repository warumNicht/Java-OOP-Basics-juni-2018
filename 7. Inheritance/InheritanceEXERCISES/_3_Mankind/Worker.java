package _3_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workingHoursPerDay;

    public Worker(String firstName, String lastname, double weekSalary, double workingHoursPerDay) {
        super(firstName, lastname);
        setWeekSalary(weekSalary);
        setWorkingHoursPerDay(workingHoursPerDay);
    }

    private void setWeekSalary(double weekSalary) {
        if(weekSalary<=10){
            throw  new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkingHoursPerDay(double workingHoursPerDay) {
        if(workingHoursPerDay<1||workingHoursPerDay>12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHoursPerDay = workingHoursPerDay;
    }

    @Override
    public String toString() {
        final StringBuilder res=new StringBuilder();

        res.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Week Salary: ").append(String.format("%.2f",this.weekSalary))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f",this.workingHoursPerDay))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f",this.weekSalary/(this.workingHoursPerDay*7) ))
                .append(System.lineSeparator());

        return res.toString();
    }
}
