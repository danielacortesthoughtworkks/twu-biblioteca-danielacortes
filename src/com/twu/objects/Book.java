package com.twu.objects;
import java.util.List;
import java.util.ArrayList;

public class Book {

    private int index;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    private static List<Book> availableBooks = new ArrayList<Book>();

    public Book(int index, String title, String author, int publicationYear, boolean available) {
        this.index = index;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = available;
        availableBooks.add(this);
    }

    public static void showAvailableBooks(){
        System.out.println(availableBooks.toString());
    }

}
