package Midterm;

import java.io.Serializable;

public class ReturnRequest implements Serializable {
    private Book bookToReturn;
    private Student studentReturning;
    private Boolean returnStatus;

    public ReturnRequest(Book book, Student student) {
        this.bookToReturn = book;
        this.studentReturning = student;
        this.returnStatus=false;
    }

    public Book getBookToReturn() {
        return bookToReturn;
    }
    public Student getStudentReturning() {
        return studentReturning;
    }
    public Boolean getReturnStatus() {
        return returnStatus;
    }

    public void setReturnAccepted() { returnStatus = true; }

    public void printStatus() {
        if (!returnStatus) {
            System.out.println("Not checked.");
        } else if (returnStatus) {
            System.out.println("Return accepted.");
        }
    }

    @Override
    public String toString() {
        return "ReturnRequest{" +
                "book=" + bookToReturn +
                ", student=" + studentReturning +
                ", status=" + returnStatus +
                "}\n-------------------------------------------";
    }
}
