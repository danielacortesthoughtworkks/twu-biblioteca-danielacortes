package com.twu.methods;

import com.twu.objects.Book;

import java.util.ArrayList;

public class manageBooks {


    private static ArrayList<Book> availableBooks = new ArrayList<Book>();

    public static void addBookToList(Book book){
        availableBooks.add(book);
    }

    public static void showAvailableBooks(){
        System.out.println(availableBooks.toString());
    }

}
