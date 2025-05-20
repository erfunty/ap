package Midterm;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String academicLevel;
    private LocalDate Registime;

    public Student(String firstName, String lastName, String studentNumber, String academicLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.academicLevel = academicLevel;
    }
    public Student(){
    }


    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getStudentNumber() { return studentNumber; }
    public String getAcademicLevel() { return academicLevel; }



    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public void setAcademicLevel(String academicLevel) { this.academicLevel = academicLevel; }
    public void setRegistrationTime(){
        Registime=LocalDate.now();
    }

    @Override
    public String toString() {
        return "{Student: " + firstName + " " + lastName +
                ", ID: " + studentNumber + ", academic level: " + academicLevel+", Registration time:"+Registime+"}";
    }
}
