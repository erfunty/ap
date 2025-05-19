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
    public String gettingBookName(){
        return in.nextLine();
    }
    public Librarian gettingLibrarianInformation(){
        Librarian librarian=new Librarian();
        System.out.println("ADDING LIBRARIAN");
        System.out.print("enter first name:");
        librarian.setFirstName(in.nextLine());
        System.out.print("enter last name:");
        librarian.setLastName(in.nextLine());
        System.out.print("enter employee ID:");
        librarian.setemployeeID(in.nextLine());

        return librarian;
    }

    public Librarian gettingInformationLibrarian(String ID){
        Librarian librarian=new Librarian();
        System.out.println("editing your information");
        System.out.print("enter first name:");
        librarian.setFirstName(in.nextLine());
        System.out.print("enter last name:");
        librarian.setLastName(in.nextLine());
        librarian.setemployeeID(ID);
        return librarian;
    }
    public Book gettingBookInformation(){
        Book book=new Book();
        System.out.println("enter book title:");
        book.setTitle(in.nextLine());
        System.out.println("enter book author name:");
        book.setAuthor(in.nextLine());
        System.out.println("enter the year of publication of the book:");
        book.setPublishYear(in.nextInt());
        System.out.println("enter number of pages in the book:");
        book.setPageCount(in.nextInt());
        return book;
    }
    public String getStudentID(){
        return in.nextLine();
    }
    public String getBookTitle(){
        System.out.println("enter book name:");
        String bookTitle=in.nextLine();
        return bookTitle;
    }
    public String getEmployeetID(){
        return in.nextLine();
    }

}
