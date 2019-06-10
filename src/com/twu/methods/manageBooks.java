package com.twu.methods;
import com.twu.objects.Book;
import java.util.ArrayList;

public class manageBooks {
    private static boolean checkOutSuccess = false;
    private static boolean returnSuccess = false;

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
                checkOutSuccess = true;
            }
        }

        if(checkOutSuccess == true) {
            manageMessages.checkOutSuccess();
            checkOutSuccess = false;
        }
        else {
            manageMessages.checkOutError();
        }
    }

    public static void returnBook(String bookChoice){
        for (Book book : allBooks) {
            String title = book.getTitle();
            if (title.equals(bookChoice)) {
                book.setAvailable(true);
                returnSuccess = true;
            }
        }
        if(returnSuccess == true) {
            manageMessages.returnSuccess();
            returnSuccess = false;
        }
        else {
            manageMessages.returnError();
        }
    }

}
