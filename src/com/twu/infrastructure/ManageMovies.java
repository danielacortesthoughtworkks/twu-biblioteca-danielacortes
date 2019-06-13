package com.twu.infrastructure;
import com.twu.model.MovieReservation;
import com.twu.model.Movie;
import com.twu.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageMovies {
    private static boolean checkOutSuccess = false;
    private static boolean returnSuccess = false;
    private static List<Movie> allMovies = new ArrayList<Movie>();
    private static  List<Movie> availableMovies = new ArrayList<Movie>();
    private User user;
    private ManageMovieMenu menu;

    public ManageMovies(User user, ManageMovieMenu menu) {
        this.user = user;
        this.menu = menu;
    }

    public static void addMovieToList(Movie movie){
        allMovies.add(movie);
    }

    public static void createAvailableList(){
        for (Movie movie : allMovies){
            boolean availability = movie.getAvailable();
            if(availability == true && !availableMovies.contains(movie)){
                availableMovies.add(movie);
            }
        }
    }

    public static void showAvailableMovies(){
        createAvailableList();
        for (Movie movie: availableMovies) {
            boolean availability = movie.getAvailable();
            if(availability == true) {
                String title = movie.getTitle();
                String director = movie.getDirector();
                int year = movie.getYear();
                int rating = movie.getRating();
                System.out.println(title + "|" + director + "|" + year + "|" + rating);
            }

        }
    }

    public void checkOutMovie(){
        User testUser = user;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String movieChoice = scan.nextLine();
            for (Movie movie: allMovies) {
                boolean availability = movie.getAvailable();
                String title = movie.getTitle();
                if (title.equals(movieChoice) && availability == true) {
                    MovieReservation reservation = new MovieReservation(movie, testUser);
                    movie.setAvailable(false);
                    checkOutSuccess = true;
                }
            }

            if (checkOutSuccess == true) {
                menu.movieCheckOutSuccess();
                checkOutSuccess = false;
            } else {
                menu.movieCheckOutError();
            }
        }
    }

    public void returnMovie(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String returnChoice = scanner.nextLine();
            for (Movie movie: allMovies) {
                String title = movie.getTitle();
                boolean availability = movie.getAvailable();
                if (title.equals(returnChoice) && availability == false) {
                    movie.setAvailable(true);
                    returnSuccess = true;
                }
            }
            if (returnSuccess == true) {
                menu.movieReturnSuccess();
                returnSuccess = false;
            } else {
                menu.movieReturnError();
            }
        }
    }
}