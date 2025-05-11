package exercises.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Book1 {
    private String title;
    private String author;
    private int pageCount;
    private int publishYear;

    public Book1(String title, String author, int pageCount, int publishYear) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.publishYear = publishYear;
    }


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPageCount() { return pageCount; }
    public int getPublishYear() { return publishYear; }


    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }

    public void printInfo() {
        System.out.println("Book: " + title + ", Author: " + author +
                ", Pages: " + pageCount + ", Year: " + publishYear);
    }
}
class Student1 {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String Field_of_study;

    public Student1(String firstName, String lastName, String studentNumber, String Field_of_study) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.Field_of_study = Field_of_study;
    }


    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getStudentNumber() { return studentNumber; }
    public String getField_of_study() { return Field_of_study; }


    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public void setField_of_study(String Field_of_study) { this.Field_of_study = Field_of_study; }

    public void printInfo() {
        System.out.println("Student: " + firstName + " " + lastName +
                ", ID: " + studentNumber + ", Field of study: " + Field_of_study);
    }
}
public class Main_EX3_LM_1_2 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Book1> books=new ArrayList<>();
        books.add(new Book1("Java Basics", "John Doe", 250, 2018));
        books.add(new Book1("Advanced Java", "Jane Smith", 400, 2021));
        books.add(new Book1("clown","me",300,2005));
        books.add(new Book1("dif","u",14,2007));
        ArrayList<Student1> students=new ArrayList<>();
        students.add(new Student1("Ali", "Ahmadi", "98123456", "Computer Engineering"));
        students.add( new Student1("Sara", "Hosseini", "99112233", "Software Engineering"));
        students.add(new Student1("amir","mohammadi","99536944","bargh"));

        saveBook(books);
        saveStudent(students);
        readstudent();
        readBook();


    }
    public static void saveStudent(ArrayList<Student1>students) throws FileNotFoundException {
        PrintWriter writerst = new PrintWriter("students.txt");
        for (Student1 st : students) {
            writerst.println(st.getFirstName() + "," + st.getLastName() + "," + st.getStudentNumber() + "," + st.getField_of_study());
        }
        writerst.close();
    }
    public static void saveBook(ArrayList<Book1> books) throws FileNotFoundException {
        PrintWriter writerb=new PrintWriter("books.txt");
        for (Book1 b:books){
            writerb.println(b.getTitle()+","+b.getAuthor()+","+b.getPageCount()+","+b.getPublishYear());
        }
        writerb.close();
    }
    public static void readstudent() throws FileNotFoundException {
        Scanner readst=new Scanner(new File("students.txt"));
        ArrayList<Student1> studentList=new ArrayList<>();
        while (readst.hasNextLine()) {
            String[] st = readst.nextLine().split(",");
            studentList.add(new Student1(st[0],st[1],st[2],st[3] ));
        }
        for (Student1 stu: studentList) {
            stu.printInfo();
        }

    }
    public static void  readBook() throws FileNotFoundException {
        Scanner readb=new Scanner(new File("books.txt"));
        ArrayList<Book1> bookList=new ArrayList<>();
        while (readb.hasNextLine()) {
            String[] bo = readb.nextLine().split(",");
            bookList.add(new Book1(bo[0],bo[1],Integer.parseInt(bo[2]),Integer.parseInt(bo[3])));
        }
        for (Book1 b : bookList) {
            b.printInfo();
        }
    }

}
