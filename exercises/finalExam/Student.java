package exercises.finalExam;

import java.io.Serializable;
import java.util.*;

public class Student implements Serializable {
    private String name;
    private String studentId;
    private String username;
    private String password;
    private List<Book> borrowedBooks = new ArrayList<>();
    private boolean isActive;

    public Student(String name, String studentId, String username, String password) {
        this.name = name;
        this.studentId = studentId;
        this.username = username;
        this.password = password;
        this.isActive=true;
    }


    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }


    @Override
    public String toString() {
        return "Name: " + name +
                " | Student ID: " + studentId +
                " | Username: " + username;
    }
}
