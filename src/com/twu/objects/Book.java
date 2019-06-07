package com.twu.objects;
import com.twu.methods.manageBooks;
public class Book {

    private int index;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;



    public Book(int index, String title, String author, int publicationYear, boolean available) {
        this.index = index;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = available;
        if(this.available == true) {
            manageBooks method = new  manageBooks();
            method.addBookToList(this);
        }
    }
}
