package _3_Mankind;

public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastname(lastName);
    }

    private void setFirstName(String firstName) {
        if(firstName.matches("[A-Z][^\\s]*")==false){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }else if(firstName.matches("[A-Z][^\\s]{3,}")==false){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private void setLastname(String lastName) {
        if(lastName.matches("[A-Z][^\\s]*")==false){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }else if(lastName.matches("[A-Z][^\\s]{2,}")==false){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    protected String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }
}
