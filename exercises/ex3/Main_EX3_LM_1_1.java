package exercises.ex3;

class Book {
    private String title;
    private String author;
    private int pageCount;
    private int publishYear;

    public Book(String title, String author, int pageCount, int publishYear) {
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
class Student {
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String Field_of_study;

    public Student(String firstName, String lastName, String studentNumber, String Field_of_study) {
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
public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {

        Book book1 = new Book("Java Basics", "John Doe", 250, 2018);
        Book book2 = new Book("Advanced Java", "Jane Smith", 400, 2021);


        Student student1 = new Student("Ali", "Ahmadi", "98123456", "Computer Engineering");
        Student student2 = new Student("Sara", "Hosseini", "99112233", "Software Engineering");


        book1.printInfo();
        book2.printInfo();
        System.out.println();
        student1.printInfo();
        student2.printInfo();
    }
}
