package com.twu.objects;
import com.twu.methods.manageMovieReservations;

public class movieReservation {
    private Movie movie;
    private User user;

    public movieReservation(Movie movie, User user){
        this.movie = movie;
        this.user = user;
        manageMovieReservations.addReservationToList(this);
    }

    public Movie getMovie() { return movie;}

    public User getUser() {
        return user;
    }
}
