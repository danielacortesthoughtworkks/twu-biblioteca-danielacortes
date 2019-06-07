package com.twu.methods;
import com.twu.objects.Book;
import java.util.ArrayList;
import java.util.UUID;
import java.math.BigInteger;

public class manageBooks {


    private static ArrayList<Book> availableBooks = new ArrayList<Book>();

    public static void addBookToList(Book book){
        availableBooks.add(book);
    }

    public static void showAvailableBooks(){
        for (Book book : availableBooks) {
            String title = book.getTitle();
            String author = book.getAuthor();
            int year = book.getPublicationYear();
            System.out.println(title + "|" + author + "|" + year);
        }
    }

    public static double setUniqueId(Book book){
        String uniqueUUID1 = UUID.randomUUID().toString();
        BigInteger bigId = new BigInteger(uniqueUUID1, 16);
        double newIndex = Math.abs(bigId.doubleValue());
        book.setIndex(newIndex);
        return newIndex;
    }
}
