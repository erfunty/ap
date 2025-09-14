package exercises.finalExam;
import java.util.Date;
public class BorrowRequest {
    private Student student;
    private Book book;
    private Date requestDate;
    private Date startDate;
    private boolean isApproved;

    public BorrowRequest(Student student, Book book, Date startDate) {
        this.student = student;
        this.book = book;
        this.startDate = startDate;

        this.requestDate = new Date();
        this.isApproved = false;
    }


    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setBorrowStartDate(Date startDate){
        this.startDate=startDate;
    }

    public boolean isApproved() {
        return isApproved;
    }
    public void setApproved(boolean approve){
        this.isApproved=approve;
    }


    public void approve() {
        this.isApproved = true;
    }
}
