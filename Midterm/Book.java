package Midterm;

public class Book {
    private String title;
    private String author;
    private int pageCount;
    private int publishYear;
    private Boolean available;

    public Book(String title, String author, int pageCount, int publishYear) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.publishYear = publishYear;
        this.available=true;
    }
    public Book(){
        this.available=true;

    }



    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPageCount() { return pageCount; }
    public int getPublishYear() { return publishYear; }
    public Boolean getAvailablity(){return available;}


    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPageCount(int pageCount) { this.pageCount = pageCount; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public void changeAvailability(){available=!available;}
    @Override
    public String toString() {
       return "{Book: " + title + ", Author: " + author +
                ", Pages: " + pageCount + ", Year: " + publishYear+"}";
    }
}
