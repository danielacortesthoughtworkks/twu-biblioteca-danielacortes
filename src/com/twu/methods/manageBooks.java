package com.twu.methods;
import com.twu.objects.Book;
import com.twu.objects.User;
import com.twu.objects.bookReservation;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class manageBooks {
    private static boolean checkOutSuccess = false;
    private static boolean returnSuccess = false;
    private manageBookMenu menu;

    private static List<Book> allBooks = new ArrayList<Book>();
    private static List<Book> availableBooks = new ArrayList<Book>();

    private User user;

    public manageBooks(User user, manageBookMenu menu) {
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
                    bookReservation reservation = new bookReservation(book, user);
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
