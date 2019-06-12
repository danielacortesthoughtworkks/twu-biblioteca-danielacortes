package com.twu.methods;
import com.twu.objects.movieReservation;
import com.twu.objects.Movie;
import com.twu.objects.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manageMovies {
    private static boolean checkOutSuccess = false;
    private static boolean returnSuccess = false;
    private static List<Movie> allMovies = new ArrayList<Movie>();
    private static  List<Movie> availableMovies = new ArrayList<Movie>();
    private static User user;

    public manageMovies(User user) {
        this.user = user;
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

    public static void checkOutMovie(){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String movieChoice = scan.nextLine();
            for (Movie movie: allMovies) {
                boolean availability = movie.getAvailable();
                String title = movie.getTitle();
                if (title.equals(movieChoice) && availability == true) {
                    movieReservation reservation = new movieReservation(movie, user);
                    movie.setAvailable(false);
                    checkOutSuccess = true;
                }
            }

            if (checkOutSuccess == true) {
                manageMovieMenu menu = new manageMovieMenu(user);
                menu.movieCheckOutSuccess();
                checkOutSuccess = false;
            } else {
                manageMovieMenu menu = new manageMovieMenu(user);
                menu.movieCheckOutError();
            }
        }
    }

    public static void returnMovie(){
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
                manageMovieMenu menu = new manageMovieMenu(user);
                menu.movieReturnSuccess();
                returnSuccess = false;
            } else {
                manageMovieMenu menu = new manageMovieMenu(user);
                menu.movieReturnError();
            }
        }
    }
}