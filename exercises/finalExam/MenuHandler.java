package exercises.finalExam;

import java.util.List;
import java.util.Scanner;


public class MenuHandler {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;
    private Librarian currenLibrarian;

    public MenuHandler(LibrarySystem librarySystem) {
        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. View Registered Student Count");
            System.out.println("4. Librarian Login");
            System.out.println("5. admin menu");
            System.out.println("6. gust menu");
            System.out.println("7. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 7);

            switch (choice) {
                case 1:
                    handleStudentRegistration();
                    break;
                case 2:
                    handleStudentLogin();
                    break;
                case 3:
                    displayStudentCount();
                    break;
                case 4:
                    handleLibrarianLogin();
                    break;
                case 5:
                    displayAdminMenu();
                    break;
                case 6:
                    displayGuestMenu();
                case 7:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displayStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }

    private void handleStudentRegistration() {
        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = librarySystem.authenticateStudent(username, password);
        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInStudentMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void displayLoggedInStudentMenu() {
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Edit My Information");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 6);

            switch (choice) {
                case 1:
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                    break;
                case 2:
                    librarySystem.editStudentInformation(currentUser);
                    break;
                case 3:
                    handleBorrowBook(currentUser);
                    break;
                case 4:
                    break;
                case 5:
                    librarySystem.displayAvailableBooks();
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
    private void handleBookSerch() {
        System.out.println("\n--- Book Search ---");

        System.out.print("Enter book title (leave blank for no search): ");
        String title = scanner.nextLine();

        System.out.print("Enter author name (leave blank for no search): ");
        String author = scanner.nextLine();

        System.out.print("Enter publish year (leave blank for no search): ");
        Integer publishYear = null;
        try {
            String yearInput = scanner.nextLine();
            if (!yearInput.isEmpty()) {
                publishYear = Integer.parseInt(yearInput);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid year. Continuing without year filter.");
        }

        List<Book> searchResults = librarySystem.searchBooks(title, author, publishYear);

        if (searchResults.isEmpty()) {
            System.out.println("No books found matching your criteria.");
        } else {
            System.out.println("\n--- Search Results ---");
            for (Book book : searchResults) {
                System.out.println(book);
            }
        }
    }
    private void handleBorrowBook(Student currentUser) {
        System.out.println("\n--- Borrow a Book ---");
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        librarySystem.borrowBook(currentUser, title);
    }
    private void displayLibrarianMenu(Librarian librarian) {
        while (true) {
            System.out.println("\n=== Librarian Dashboard ===");
            System.out.println("1. Change My Password");
            System.out.println("2. Add new book");
            System.out.println("3. Edit book information");
            System.out.println("4. manage borrow request");
            System.out.println("5. view student borrowing history");
            System.out.println("6. Activate/deactivate student");
            System.out.println("7. return a book");
            System.out.println("8. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1,8);

            switch (choice) {
                case 1:
                    handleChangePassword();
                    break;
                case 2:
                    handleAddBook();
                    break;
                case 3:
                    handleEditBook();
                    break;
                case 4:
                    handleViewBorrowRequests();
                    break;
                case 5:
                    handleBorrowingHistoryReport();
                    break;
                case 6:
                    handleActivateDeactivateStudent();
                    break;
                case 7:
                    handleReturnBook();
                    break;
                case 8:
                    System.out.println("Logged out successfully.");
                    currenLibrarian=null;
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
    private void handleLibrarianLogin() {
        System.out.println("\n=== Librarian Dashboard ===");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currenLibrarian = librarySystem.authenticateLibrarian(username, password);
        if (currenLibrarian != null) {
            System.out.println("Login successful! Welcome, " + currenLibrarian.getName());
            displayLibrarianMenu(currenLibrarian);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }
    private void handleChangePassword() {
        System.out.println("\n--- Change Password ---");
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        currenLibrarian.setPassword(newPassword);
        librarySystem.changeLibrarianPassword(currenLibrarian.getUsername(),newPassword);
    }
    private void handleAddBook() {
        System.out.println("\n--- Add a New Book ---");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book publish year: ");
        int publishYear = scanner.nextInt();


        boolean isAvailable = true;

        librarySystem.addBook(title, author, publishYear, isAvailable);
        System.out.println("Book added successfully!");
    }
    private void handleEditBook() {
        System.out.println("\n--- Edit Book Information ---");


        System.out.print("Enter the title of the book to edit: ");
        String title = scanner.nextLine();

        System.out.print("Enter new title (leave blank to keep current): ");
        String newTitle = scanner.nextLine();

        System.out.print("Enter new author (leave blank to keep current): ");
        String newAuthor = scanner.nextLine();

        System.out.print("Enter new publish year (leave blank to keep current): ");
        String yearInput = scanner.nextLine();
        int newPublishYear = 0;
        if (!yearInput.isEmpty()) {
            try {
                newPublishYear = Integer.parseInt(yearInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year input. Keeping the current year.");
            }
        }

        System.out.print("Enter new availability status (true/false, leave blank to keep current): ");
        String availabilityInput = scanner.nextLine();
        boolean newAvailability = false;
        if (!availabilityInput.isEmpty()) {
            newAvailability = Boolean.parseBoolean(availabilityInput);
        }

        librarySystem.editBook(title, newTitle, newAuthor, newPublishYear, newAvailability);
    }
    private void handleViewBorrowRequests() {
        System.out.println("\n--- Borrow Requests ---");


        if (librarySystem.getBorrowRequestList().isEmpty()) {
            System.out.println("No borrow requests available.");
            return;
        }

        for (int i = 0; i < librarySystem.getBorrowRequestList().size(); i++) {
            BorrowRequest request = librarySystem.getBorrowRequestList().get(i);
            System.out.println((i + 1) + ". " + request.getBook() + " | Requested by: " + request.getStudent().getName());
        }


        System.out.print("Enter the number of the borrow request to approve or reject (0 to cancel): ");
        int choice = getIntInput(0, librarySystem.getBorrowRequestList().size());

        if (choice == 0) {
            System.out.println("Returning to the previous menu.");
            return;
        }


        BorrowRequest request = librarySystem.getBorrowRequestList().get(choice - 1);

        System.out.println("1. Approve request and start borrowing");
        System.out.println("2. Reject request and remove");
        System.out.print("Please enter your choice (1 or 2): ");

        int actionChoice = getIntInput(1, 2);

        if (actionChoice == 1) {
            librarySystem.approveBorrowRequest(request);
        } else if (actionChoice == 2) {
            librarySystem.removeBorrowRequest(request);
        }
    }
    private void handleBorrowingHistoryReport() {
        System.out.print("\nEnter the student ID to view borrowing history: ");
        String studentId = scanner.nextLine();

        Student student = librarySystem.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        BorrowingHistoryReport report = librarySystem.generateBorrowingHistoryReport(student);
        System.out.println("\n--- Borrowing History Report for Student: " + student.getName() + " ---");
        System.out.println("Total borrowings: " + report.getTotalBorrowings());
        System.out.println("Total books not returned: " + report.getBooksNotReturned());
        System.out.println("Total late returns: " + report.getLateReturns());
    }
    private void handleActivateDeactivateStudent() {
        System.out.print("\nEnter the student ID to activate/deactivate: ");
        String studentId = scanner.nextLine();

        Student student = librarySystem.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current status: " + (student.isActive() ? "Active" : "Inactive"));
        System.out.print("Do you want to change the status? (1: Activate, 2: Deactivate): ");
        int choice = getIntInput(1, 2);

        if (choice == 1) {
            student.setActive(true);
            System.out.println("Student has been activated.");
        } else if (choice == 2) {
            student.setActive(false);
            System.out.println("Student has been deactivated.");
        }
    }
    private void handleReturnBook() {
        System.out.print("\nEnter the student ID to return a book: ");
        String studentId = scanner.nextLine();

        Student student = librarySystem.getStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("\nEnter the title of the book to return: ");
        String bookTitle = scanner.nextLine();

        Book book = null;
        for (Book borrowedBook : student.getBorrowedBooks()) {
            if (borrowedBook.getTitle().equalsIgnoreCase(bookTitle)) {
                book = borrowedBook;
                break;
            }
        }

        if (book != null) {
            librarySystem.receiveBookFromStudent(student, book);
        } else {
            System.out.println("The student doesn't have this book.");
        }
    }
    public void displayGuestMenu() {
        while (true) {
            System.out.println("\n=== Guest Menu ===");
            System.out.println("1. View Registered Student Count");
            System.out.println("2. Search Books by Title");
            System.out.println("3. View Basic Statistics (Students, Books, Borrowed Books)");
            System.out.println("4. Go Back");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 4);

            switch (choice) {
                case 1:
                    viewStudentCount();
                    break;
                case 2:
                    searchBooksByTitle();
                    break;
                case 3:
                    viewStatistics();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
    private void viewStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }
    private void searchBooksByTitle() {
        System.out.println("\n--- Book Search by Title ---");
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        List<Book> searchResults = librarySystem.searchBooks(title, null, null);

        if (searchResults.isEmpty()) {
            System.out.println("No books found with the given title.");
        } else {
            System.out.println("\n--- Search Results ---");
            for (Book book : searchResults) {
                System.out.println(book);
            }
        }
    }
    private void viewStatistics() {
        int studentCount = librarySystem.getStudentCount();
        int bookCount = librarySystem.getBookList().size();
        int totalBorrowedBooks = librarySystem.getTotalBorrowedBooks();

        int lastBorrowedBookCount = librarySystem.getborrowr().size();

        System.out.println("\n=== Library Statistics ===");
        System.out.println("Total number of students: " + studentCount);
        System.out.println("Total number of books: " + bookCount);
        System.out.println("Total number of borrowed books: " + totalBorrowedBooks);
        System.out.println("Number of last borrowed books: " + lastBorrowedBookCount);
    }




    private void displayAdminMenu() {
        while (true) {
            System.out.println("\n=== Admin Dashboard ===");
            System.out.println("1. Add Librarian");
            System.out.println("2. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 2);

            switch (choice) {
                case 1:
                    handleAddLibrarian();
                    break;
                case 2:
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void handleAddLibrarian() {
        System.out.println("\n--- Add Librarian ---");

        System.out.print("Enter librarian name: ");
        String name = scanner.nextLine();

        System.out.print("Enter librarian username: ");
        String username = scanner.nextLine();

        System.out.print("Enter librarian password: ");
        String password = scanner.nextLine();

        librarySystem.addLibrarian(name, username, password);
    }


    private int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
