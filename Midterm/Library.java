package Midterm;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Book> bookList=new ArrayList<>();
    private ArrayList<Student> studentList=new ArrayList<>();
    private ArrayList<Librarian> librarianList=new ArrayList<>();
    private ArrayList<Borrow> borrowsList=new ArrayList<>();
    InputProcessing inputLibrary;

    public Library(String libraryName,InputProcessing inputProcessing){
        this.name=libraryName;
        this.inputLibrary=inputProcessing;
    }
    public String getName(){return name;}
    public void studentRegistration(){
        studentList.add(inputLibrary.gettingStudentInformation());
        System.out.println("You have registered ");
    }




}
