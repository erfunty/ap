package Midterm;

import java.io.Serializable;

public class Request implements Serializable {
    private Book bookrequested;
    private Student studentrequest;
    private Boolean requeststatus;
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
    public Boolean getRequeststatus(){
        return requeststatus;
    }
    public void setRequeststatusTrue(){
        requeststatus=true;
    }
    public void setRequeststatusFalse(){
        requeststatus=false;
    }
    public void printStatus(){
        if (requeststatus == null) {
            System.out.println("Not checked.");
        } else if (requeststatus) {
            System.out.println("accepted.");
        } else {
            System.out.println("rejected.");
        }
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

