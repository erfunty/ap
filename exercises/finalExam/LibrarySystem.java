package exercises.finalExam;

import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    private StudentManager studentManager;
    private MenuHandler menuHandler;
    private List<Book> bookList;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.menuHandler = new MenuHandler(this);
        this.bookList=new ArrayList<>();
        loadBook();
    }

    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
    }

    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }

    public void editStudentInformation(Student student) {
        System.out.println("Not implemented.");
    }

    public void borrowBook(Student student) {
        System.out.println("Not implemented.");
    }

    public void returnBook(Student student) {
        System.out.println("Not implemented.");
    }
    public void addBook(String title, String author, int publishYear, boolean isAvailable) {
        Book newBook = new Book(title, author, publishYear, isAvailable);
        bookList.add(newBook);
    }

    public List<Book> searchBooks(String title, String author, Integer publishYear) {
        List<Book> results = new ArrayList<>();
        for (Book book : bookList) {
            boolean matches = true;

            if (title != null && !book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matches = false;
            }

            if (author != null && !book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                matches = false;
            }
            if (publishYear != null && book.getPublishYear() != publishYear) {
                matches = false;
            }
            if (matches) {
                results.add(book);
            }
        }
        return results;
    }


    private void loadBook() {
        addBook("clwon", "me", 1988, true);
    }


    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    public void start() {
        menuHandler.displayMainMenu();
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}
