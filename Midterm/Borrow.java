package Midterm;

import java.io.Serializable;
import java.time.LocalDate;


public class Borrow implements Serializable {
    private Book borrowedBook;
    private Student studentBorrowing;
    private Librarian givingLibrarian;
    private Librarian receivingLibrarian;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private LocalDate dueDate;
    public Borrow(Book book,Student student,Librarian librarian){
         this.borrowedBook=book;
         this.studentBorrowing=student;
         this.givingLibrarian=librarian;
         borrowDate=LocalDate.now();
         returnDate=borrowDate.plusDays(20);
    }

    public Book getBorrowedBook() {
        return borrowedBook;
    }
    public Student getStudentBorrowing() {
        return studentBorrowing;
    }
    public Librarian getgivingLibrarian() {
        return givingLibrarian;
    }
    public Librarian getReceivingLibrarian() {
        return receivingLibrarian;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    public void setDueDate(){
        dueDate=LocalDate.now();
    }

    public void setReceivingLibrarian(Librarian receivingLibrarian) {
        this.receivingLibrarian = receivingLibrarian;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "book=" + borrowedBook.getTitle() +
                ", student=" + studentBorrowing +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                '}';
    }




}
