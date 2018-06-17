package _3_Mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastname, String facultyNumber) {
        super(firstName, lastname);
        setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if(facultyNumber.matches("^\\d{5,10}$")==false){
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    @Override
    public String toString() {
        final StringBuilder res=new StringBuilder();

        res.append("First Name: ").append(super.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(super.getLastName())
                .append(System.lineSeparator())
                .append("Faculty number: ").append(this.facultyNumber);


        return res.toString();
    }
}
