package com.twu.methods;
import com.twu.objects.Book;
import com.twu.objects.User;
import com.twu.objects.bookReservation;
import java.util.ArrayList;
import java.util.List;

public class manageBookReservations {

    private static List<bookReservation> allBookReservations = new ArrayList<bookReservation>();


    public static void addReservationToList(bookReservation reservation){
        allBookReservations.add(reservation);
    }

    public static void showAllBookReservations(){
        for (bookReservation reservation : allBookReservations){
            Book book = reservation.getBook();
            User user = reservation.getUser();
            String title = book.getTitle();
            String name = user.getName();
            System.out.println(title + "|" + name);
        }


    }
}