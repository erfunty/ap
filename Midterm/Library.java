package Midterm;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> bookList=new ArrayList<>();
    private ArrayList<Student> studentList=new ArrayList<>();
    private ArrayList<Librarian> librarianList=new ArrayList<>();
    private ArrayList<Borrow> borrowsList=new ArrayList<>();
    private ArrayList<Request> requestList=new ArrayList<>();
    InputProcessing inputLibrary;

    public Library(String libraryName,InputProcessing inputProcessing){
        this.name=libraryName;
        this.inputLibrary=inputProcessing;
        studentList.add(new Student("erfan","sohrabi","403463126","inter"));
        bookList.add(new Book("clown","me",300,2005));
        bookList.add(new Book("Java Basics", "John Doe", 250, 2018));
        librarianList.add(new Librarian("ali","dz","402"));

    }
    public String getName(){return name;}
    public void studentRegistration(){
        studentList.add(inputLibrary.gettingStudentInformation());
        System.out.println("You have registered successfully");
    }
    public void searchingBook(){
        for (Book book : bookList) {
            if (book.getTitle().equals(inputLibrary.gettingBookName())){
                System.out.println(book);
            }
        }
    }
    public void addLibrarian(){
        librarianList.add(inputLibrary.gettingLibrarianInformation());
    }
    public void editingInformationLibrarian(String ID){
        for (int i = 0; i <librarianList.size() ; i++) {
            if (librarianList.get(i).getEmployeeID().equals(ID)){
                librarianList.set(i,inputLibrary.gettingInformationLibrarian(ID));
            }
        }

    }
    public void addBook(){
        bookList.add(inputLibrary.gettingBookInformation());
        System.out.println("Book added successfully.");
    }
    public boolean checkExistStudent(String ID){
        for (Student student : studentList) {
            if (student.getStudentNumber().equals(ID)){
                System.out.println("Login successfully.");
                return true;
            }
        }
        System.out.println("student not found.");
        return false;
    }
    public boolean checkExistLibrarian(String ID){
        for (Librarian librarian : librarianList) {
            if (librarian.getEmployeeID().equals(ID)){
                System.out.println("Login successfully.");
                return true;
            }
        }
        System.out.println("librarian not found.");
        return false;
    }
    public void borrowingBookRequest(String ID){
        Book bookBorrowing;
        String bookName= inputLibrary.getBookTitle();
        for (Book book : bookList) {
            if (bookName.equals(book.getTitle())){
                if (book.getAvailablity()==true){
                    for (Student student : studentList) {
                        if (student.getStudentNumber().equals(ID)){
                            bookBorrowing=book;
                            requestList.add(new Request(bookBorrowing,student));
                            System.out.println("requested seccessfully.");
                            return;
                        }
                    }
                }else {
                    System.out.println("the book has already been borrowed.");
                    return;
                }
            }
        }
        System.out.println("book not found.");
    }
    public void checkingRequests(String ID){
        for (Librarian librarian : librarianList) {
            if (librarian.getEmployeeID().equals(ID)){
                String choice;
                do {
                    System.out.println("______requests______");
                    int i=1;
                    for (Request request : requestList) {
                        System.out.println(i+"."+request);
                        i++;
                    }
                    choice=inputLibrary.gettingInput();
                    int index=Integer.parseInt(choice)-1;
                    System.out.println(" 1.Accept book request\n" +
                            " 2.Reject book request");
                    choice=inputLibrary.gettingInput();
                    if (choice.equals("1")){
                        borrowsList.add(new Borrow(requestList.get(index).getBookrequested(),requestList.get(index).getStudentrequest(),librarian));
                        requestList.get(index).setRequeststatusTrue();
                        for (int j = 0; j < bookList.size(); j++) {
                            if (bookList.get(j).equals(requestList.get(index).getBookrequested())){
                                bookList.get(j).changeAvailability();
                            }
                        }
                        //requestList.remove(index);
                        System.out.println("request Accepted.");
                    } else if (choice.equals("2")) {
                        requestList.get(index).setRequeststatusFalse();
                        System.out.println("request Rejected.");

                    }
                }while (!choice.equals("q"));
            }
        }
    }
    public void showStudentBooks(){


    }

}
