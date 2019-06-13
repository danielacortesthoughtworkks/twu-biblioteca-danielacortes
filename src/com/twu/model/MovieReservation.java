package com.twu.model;
import com.twu.infrastructure.ManageMovieReservations;
import com.twu.infrastructure.ManageMainMenu;

public class MovieReservation {
    private Movie movie;
    private User user;

    public MovieReservation(Movie movie, User user){
        this.movie = movie;
        this.user = user;
        ManageMovieReservations.addReservationToList(this);
        ManageMainMenu.addMovieReservationToList(this);
    }

    public Movie getMovie() { return movie;}

    public User getUser() {
        return user;
    }
}
