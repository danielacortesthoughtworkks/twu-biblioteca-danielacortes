package com.twu.methods;
import com.twu.objects.Book;
import java.util.ArrayList;
import java.util.UUID;
import java.math.BigInteger;

public class manageBooks {
    private String bookChoice;

    private static ArrayList<Book> allBooks = new ArrayList<Book>();
    private static ArrayList<Book> availableBooks = new ArrayList<Book>();

    public static void addBookToList(Book book){
        allBooks.add(book);
    }

    public static void createAvailableList(){
        for (Book book : allBooks){
            boolean availability = book.getAvailable();
            if(availability == true && !availableBooks.contains(book)){
                availableBooks.add(book);
            }
        }
    }

    public static void showAvailableBooks(){
        createAvailableList();
        for (Book book : availableBooks) {
           boolean availability = book.getAvailable();
            if(availability == true) {
                String title = book.getTitle();
                String author = book.getAuthor();
                int year = book.getPublicationYear();
                System.out.println(title + "|" + author + "|" + year);
            }
        }
    }

    public static void checkOutBook(String bookChoice){
        for (Book book : allBooks) {
            String title = book.getTitle();
            if (title.equals(bookChoice)) {
                book.setAvailable(false);
            }
        }
        manageMessages.checkOutSuccess();
    }

    public static void returnBook(String bookChoice){
        for (Book book : allBooks) {
            String title = book.getTitle();
            if (title.equals(bookChoice)) {
                book.setAvailable(true);
            }
        }
    }

}
