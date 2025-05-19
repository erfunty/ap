package Midterm;

public class Request {
    private Book bookrequested;
    private Student studentrequest;
    private boolean requeststatus;
    public Request(Book book,Student student){
    this.bookrequested=book;
    this.studentrequest=student;
    }
    public Book getBookrequested(){
        return bookrequested;
    }
    public Student getStudentrequest(){
        return studentrequest;
    }
    public void setRequeststatusTrue(){
        requeststatus=true;
    }
    public void setRequeststatusFalse(){
        requeststatus=false;
    }


    @Override
    public String toString() {
        return "Request{" +
                "book requested=" + bookrequested +
                ",\n student=" + studentrequest +
                ",\n request status=" + requeststatus +
                '}'+"\n-------------------------------------------";
    }
}

