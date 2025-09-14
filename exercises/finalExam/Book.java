package exercises.finalExam;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private String title;
    private String author;
    private int publishYear;
    private boolean isAvailable;
    private Date borrowStartDate;
    private Date borrowEndDate;

    public Book(String title, String author, int publishYear, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.isAvailable = isAvailable;
        this.borrowStartDate=null;
        this.borrowEndDate=null;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available){
        this.isAvailable=available;
    }
    public Date getBorrowStartDate(){
        return borrowStartDate;
    }
    public void setBorrowStartDate(Date borrowStartDate){
        this.borrowStartDate= borrowStartDate;
    }
    public Date getBorrowEndDate(){
        return borrowEndDate;
    }
    public void setborrowEndDate(Date borrowStartDate){
        this.borrowEndDate= borrowEndDate;
    }
    public void setTitle(String newTitle) {
        this.title=newTitle;
    }
    public void setAuthor(String newAuthor) {
        this.author=newAuthor;
    }
    public void setPublishYear(int newPublishYear) {
        this.publishYear=newPublishYear;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                " | Author: " + author +
                " | Year: " + publishYear +
                " | Available: " + (isAvailable ? "Yes" : "No");
    }


    public void setReturnDate(Date returnDate) {
        this.borrowEndDate=returnDate;
    }
}
