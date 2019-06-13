package com.twu.infrastructure;
import com.twu.model.Book;
import com.twu.model.User;
import com.twu.model.BookReservation;
import java.util.ArrayList;
import java.util.List;

public class ManageBookReservations {

    private static List<BookReservation> allBookReservations = new ArrayList<BookReservation>();


    public static void addReservationToList(BookReservation reservation){
        allBookReservations.add(reservation);
    }

    public static void showAllBookReservations(){
        for (BookReservation reservation : allBookReservations){
            Book book = reservation.getBook();
            User user = reservation.getUser();
            String title = book.getTitle();
            String name = user.getName();
            System.out.println(title + "|" + name);
        }


    }
}