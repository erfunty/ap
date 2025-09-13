package exercises.finalExam;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int publishYear;
    private boolean isAvailable;

    public Book(String title, String author, int publishYear, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.isAvailable = isAvailable;
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

    @Override
    public String toString() {
        return "Title: " + title +
                " | Author: " + author +
                " | Year: " + publishYear +
                " | Available: " + (isAvailable ? "Yes" : "No");
    }

}
