package com.twu.objects;
import com.twu.methods.manageBooks;
public class Book {

    private double index;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;



    public Book(double index, String title, String author, int publicationYear, boolean available) {
        this.index = index;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = available;
        manageBooks.addBookToList(this);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean getAvailable() {
        return available;
    }

    public void setIndex(double newIndex) {
        this.index = newIndex;
    }

    public void setAvailable(boolean availabilty) {
        this.available = availabilty;
    }
}
