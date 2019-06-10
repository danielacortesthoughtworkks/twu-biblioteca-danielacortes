package com.twu.methods;
import com.twu.objects.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class manageMovies {
    private static boolean checkOutSuccess = false;
    private static boolean returnSuccess = false;

    private static ArrayList<Movie> allMovies = new ArrayList<Movie>();
    private static ArrayList<Movie> availableMovies = new ArrayList<Movie>();

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
                String title = movie.getTitle();
                if (title.equals(movieChoice)) {
                    movie.setAvailable(false);
                    checkOutSuccess = true;
                }
            }

            if (checkOutSuccess == true) {
                manageMessages.movieCheckOutSuccess();
                checkOutSuccess = false;
            } else {
                manageMessages.movieCheckOutError();
            }
        }
    }

    public static void returnMovie(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String returnChoice = scanner.nextLine();
            for (Movie movie: allMovies) {
                String title = movie.getTitle();
                if (title.equals(returnChoice)) {
                    movie.setAvailable(true);
                    returnSuccess = true;
                }
            }
            if (returnSuccess == true) {
                manageMessages.movieReturnSuccess();
                returnSuccess = false;
            } else {
                manageMessages.movieReturnError();
            }
        }
    }
}