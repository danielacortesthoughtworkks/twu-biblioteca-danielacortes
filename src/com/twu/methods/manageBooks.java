package com.twu.methods;
import com.twu.objects.Book;
import com.twu.objects.User;

import java.util.ArrayList;
import java.util.Scanner;

public class manageBooks {
    private static boolean checkOutSuccess = false;
    private static boolean returnSuccess = false;

    private static ArrayList<Book> allBooks = new ArrayList<Book>();
    private static ArrayList<Book> availableBooks = new ArrayList<Book>();

    private static User user;

    public manageBooks(User user) {
        this.user = user;
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

    public static void checkOutBook(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String bookChoice = scan.nextLine();
            for (Book book : allBooks) {
                boolean availability = book.getAvailable();
                String title = book.getTitle();
                if (title.equals(bookChoice) && availability == true) {
                    book.setAvailable(false);
                    checkOutSuccess = true;
                }
            }

            if (checkOutSuccess == true) {
                manageBookMenu menu = new manageBookMenu(user);
                menu.bookCheckOutSuccess();
                checkOutSuccess = false;
            } else {
                manageBookMenu menu = new manageBookMenu(user);
                menu.bookCheckOutError();
            }
        }
    }

    public static void returnBook(){
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
                manageBookMenu menu = new manageBookMenu(user);
                menu.bookReturnSuccess();
                returnSuccess = false;
            } else {
                manageBookMenu menu = new manageBookMenu(user);
                menu.bookReturnError();
            }
        }
    }
}
