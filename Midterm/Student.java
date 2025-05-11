package Midterm;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String FieldOfStudy;
    private LocalDate Registime;

    public Student(String firstName, String lastName, String studentNumber, String FieldOfStudy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.FieldOfStudy = FieldOfStudy;
    }


    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getStudentNumber() { return studentNumber; }
    public String getFieldOfStudy() { return FieldOfStudy; }



    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public void setFieldOfStudy(String FieldOfStudy) { this.FieldOfStudy = FieldOfStudy; }
    public void setRegistrationTime(){
        Registime=LocalDate.now();
    }

    public void printInfo() {
        System.out.println("Student: " + firstName + " " + lastName +
                ", ID: " + studentNumber + ", Field of study: " + FieldOfStudy+", Registration time:"+Registime);
    }
}
