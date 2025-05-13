package Midterm;

import java.util.Scanner;

public class InputProcessing {
    private Scanner in=new Scanner(System.in);
    public String gettingInput(){
        return in.nextLine();
    }
    public Student gettingStudentInformation(){
        Student student=new Student();
        System.out.println("REGISTRATION");
        System.out.print("enter your first name:");
        student.setFirstName(in.nextLine());
        System.out.print("enter your last name:");
        student.setLastName(in.nextLine());
        System.out.print("enter your student number:");
        student.setStudentNumber(in.nextLine());
        System.out.print("enter your academic level:");
        student.setAcademicLevel(in.nextLine());
        student.setRegistrationTime();
        return student;
    }

}
