package com.twu.infrastructure;
import com.twu.model.Book;
import com.twu.model.User;
import com.twu.model.BookReservation;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageBooks {
    private static boolean checkOutSuccess = false;
    private static boolean returnSuccess = false;
    private ManageBookMenu menu;

    private static List<Book> allBooks = new ArrayList<Book>();
    private static List<Book> availableBooks = new ArrayList<Book>();

    private User user;

    public ManageBooks(User user, ManageBookMenu menu) {
        this.user = user;
        this.menu = menu;
    }

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

    public void checkOutBook(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String bookChoice = scan.nextLine();
            for (Book book : allBooks) {
                boolean availability = book.getAvailable();
                String title = book.getTitle();
                if (title.equals(bookChoice) && availability == true) {
                    BookReservation reservation = new BookReservation(book, user);
                    book.setAvailable(false);
                    checkOutSuccess = true;
                }
            }

            if (checkOutSuccess == true) {
                menu.bookCheckOutSuccess();
                checkOutSuccess = false;
            } else {
                menu.bookCheckOutError();
            }
        }
    }

    public void returnBook(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String returnChoice = scanner.nextLine();
            for (Book book : allBooks) {
                boolean availability = book.getAvailable();
                String title = book.getTitle();
                if (title.equals(returnChoice) && availability == false) {
                    book.setAvailable(true);
                    returnSuccess = true;
                }
            }
            if (returnSuccess == true) {
                menu.bookReturnSuccess();
                returnSuccess = false;
            } else {
                menu.bookReturnError();
            }
        }
    }
}
