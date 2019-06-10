package com.twu.objects;
import com.twu.methods.manageMovies;

public class Movie {

    private double index;
    private String title;
    private String director;
    private int year;
    private int rating;
    private boolean available;

    public Movie(double index, String title, String director, int year, int rating, boolean available) {
        this.index = index;
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.available = available;
        manageMovies.addMovieToList(this);
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {return rating;}

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean availabilty) {
        this.available = availabilty;
    }
}
