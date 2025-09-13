package exercises.finalExam;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibrarySystem {
    private SystemManager systemManager;
    private StudentManager studentManager;
    private MenuHandler menuHandler;
    private List<Librarian> librarians;
    private List<Book> bookList;
    private List<BorrowRequest> borrowRequestList;

    public LibrarySystem() {
        this.systemManager=new SystemManager();
        this.studentManager = new StudentManager();
        this.menuHandler = new MenuHandler(this);
        this.librarians=new ArrayList<>();
        this.bookList=new ArrayList<>();
        this.borrowRequestList=new ArrayList<>();
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

    public void borrowBook(Student currentUser, String title) {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }

        Book bookToBorrow = findBookByTitle(title);
        if (bookToBorrow == null) {
            System.out.println("Book not found.");
            return;
        }

        if (bookToBorrow.isAvailable()) {
            BorrowRequest newRequest = new BorrowRequest(currentUser, bookToBorrow, new Date());
            borrowRequestList.add(newRequest);
            System.out.println("Borrow request added successfully.");
        } else {
            System.out.println("Book is unavailable for borrowing.");
        }
    }


    public List<Book> getBorrowedBooks(Student student) {
        List<Book> borrowedBooks = new ArrayList<>();
        for (BorrowRequest request : borrowRequestList) {
            if (request.getStudent().equals(student) && request.isApproved()) {
                borrowedBooks.add(request.getBook());
            }
        }
        return borrowedBooks;
    }


    public Book findBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
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
    public void editBook(String title, String newTitle, String newAuthor, int newPublishYear, boolean newAvailability) {
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);

            if (book.getTitle().equalsIgnoreCase(title)) {

                if (newTitle != null && !newTitle.isEmpty()) {
                    book.setTitle(newTitle);
                }
                if (newAuthor != null && !newAuthor.isEmpty()) {
                    book.setAuthor(newAuthor);
                }
                if (newPublishYear != 0) {
                    book.setPublishYear(newPublishYear);
                }
                book.setAvailable(newAvailability);


                System.out.println("Book information updated successfully in memory!");
                return;
            }
        }

        System.out.println("Book with title \"" + title + "\" not found.");
    }
    private void saveBooks() {
        try (ObjectOutputStream bookWriter = new ObjectOutputStream(new FileOutputStream("books.dat"))) {
            bookWriter.writeObject(bookList);
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }
    public void addLibrarian(String name, String username, String password) {
        Librarian newLibrarian = new Librarian(name, username, password);
        librarians.add(newLibrarian);
        System.out.println("Librarian added successfully: " + name);
    }

    public Librarian authenticateLibrarian(String username, String password) {
        for (Librarian librarian : librarians) {
            if (librarian.getUsername().equals(username) && librarian.getPassword().equals(password)) {
                return librarian;
            }
        }
        return null;
    }
    public Librarian findLibrarianByUsername(String username) {
        for (Librarian l : librarians) {
            if (l.getUsername().equals(username)) return l;
        }
        return null;
    }
    public boolean changeLibrarianPassword(String username, String newPassword) {
        Librarian l = findLibrarianByUsername(username);
        if (l != null) {
            l.setPassword(newPassword);
            return true;
        }
        return false;
    }
    public List<Librarian> getLibrarians(){
        return librarians;
    }



    private void loadBook() {
        File file = new File("books.dat");
        if (!file.exists()) return;

        try (ObjectInputStream bookReader = new ObjectInputStream(new FileInputStream(file))) {
            bookList = (List<Book>) bookReader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
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
