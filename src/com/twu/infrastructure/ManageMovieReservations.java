package com.twu.infrastructure;
import com.twu.model.Movie;
import com.twu.model.User;
import com.twu.model.MovieReservation;
import java.util.ArrayList;
import java.util.List;

public class ManageMovieReservations {

    private static List<MovieReservation> allMovieReservations = new ArrayList<MovieReservation>();


    public static void addReservationToList(MovieReservation reservation){
        allMovieReservations.add(reservation);
    }

    public static void showAllMovieReservations(){
        for (MovieReservation reservation : allMovieReservations){
            Movie movie = reservation.getMovie();
            User user = reservation.getUser();
            String title = movie.getTitle();
            String name = user.getName();
            System.out.println(title + "|" + name);
        }


    }
}
