package Midterm;

public class Librarian {
    private String firstName;
    private String lastName;
    private String employeeID;

    public Librarian(String firstName,String lastName,String employeeID){
        this.firstName=firstName;
        this.lastName=lastName;
        this.employeeID=employeeID;
    }
    public Librarian(){

    }
    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String getEmployeeID(){return employeeID;}

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setemployeeID(String employeeID) { this.employeeID= employeeID; }
    public void printInfo() {
        System.out.println("first name: " + firstName + ", last name: " + lastName +
                ", employee ID: "+employeeID);
    }

}
