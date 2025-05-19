package Midterm;

import java.time.LocalDate;


public class Borrow {
    private Book borrowedBook;
    private Student studentBorrowing;
    private Librarian givingLibrarian;
    private Librarian receivingLibrarian;
    private LocalDate borrowdate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    public Borrow(Book book,Student student,Librarian librarian){
         this.borrowedBook=book;
         this.studentBorrowing=student;
         this.givingLibrarian=librarian;
         borrowdate=LocalDate.now();
         returnDate=borrowdate.plusDays(20);
    }



}
