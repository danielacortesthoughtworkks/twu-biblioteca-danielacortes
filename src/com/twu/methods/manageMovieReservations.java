package com.twu.methods;
import com.twu.objects.Movie;
import com.twu.objects.User;
import com.twu.objects.movieReservation;
import java.util.ArrayList;
import java.util.List;

public class manageMovieReservations {

    private static List<movieReservation> allMovieReservations = new ArrayList<movieReservation>();


    public static void addReservationToList(movieReservation reservation){
        allMovieReservations.add(reservation);
    }

    public static void showAllMovieReservations(){
        for (movieReservation reservation : allMovieReservations){
            Movie movie = reservation.getMovie();
            User user = reservation.getUser();
            String title = movie.getTitle();
            String name = user.getName();
            System.out.println(title + "|" + name);
        }


    }
}
