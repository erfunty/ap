package Midterm;

import java.io.Serializable;

public class Manager implements Serializable {
    private String firstName;
    private String lastName;
    private String educationLevel;

    public Manager(String firstName,String lastName,String educationLevel){
        this.firstName=firstName;
        this.lastName=lastName;
        this.educationLevel=educationLevel;
    }


    public String getFirstName(){return firstName;}
    public String getLastName(){return lastName;}
    public String geteducationLevel(){return educationLevel;}

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void seteducationLevel(String educationLevel) { this.educationLevel= educationLevel; }
    public void printInfo() {
        System.out.println("first name: " + firstName + ", last name: " + lastName +
                ", educationLevel: " + educationLevel);
    }
}
