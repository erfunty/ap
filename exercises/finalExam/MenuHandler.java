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
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 6);

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
            System.out.println("3. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1,3);

            switch (choice) {
                case 1:
                    handleChangePassword();
                    break;
                case 2:
                    handleAddBook();
                case 3:
                    System.out.println("Logged out successfully.");
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
