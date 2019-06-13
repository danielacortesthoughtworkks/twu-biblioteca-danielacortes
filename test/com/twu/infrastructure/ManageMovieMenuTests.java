package com.twu.infrastructure;
import com.twu.model.Movie;
import com.twu.model.User;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Before;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.lang.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ManageMovieMenuTests {


    private User user;
    private ManageMainMenu mainMenu;
    private ManageMovieMenu menu;
    private ManageMovies movieManager;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void createMessage(){
        systemOutRule.clearLog();
        user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com",
                79298644);
        mainMenu = new ManageMainMenu(user);
        menu = new ManageMovieMenu(user, mainMenu);
        movieManager = new ManageMovies(user, menu);
    }

    @Test
    public void movieSubMenuShouldDisplayBookListWhenChoosingOptionA(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        Movie movie2 = new Movie (2, "Empire Records", "Ethan Embry", 1996, 10, true);
        Movie movie3 = new Movie (1, "Hola hola", "Playa beach", 1994, 5, false);
        String title = movie.getTitle();
        String director = movie.getDirector();
        int year = movie.getYear();
        int rating = movie.getRating();
        String title2 = movie2.getTitle();
        String director2 = movie2.getDirector();
        int year2 = movie2.getYear();
        int rating2 = movie2.getRating();
        String input = "A";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMovieSubMenuChoice();
        assertEquals(title + "|" + director + "|" + year + "|" + rating + "\n" +
                title2 + "|" + director2 + "|" + year2 + "|" + rating2 + "\n" +
                "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }


    @Test
    public void movieSubMenuShouldAskForCheckOutBookTitleWhenChoosingOptionB(){
        String input = "B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMovieSubMenuChoice();
        assertEquals("What movie would you like to check out?\n", systemOutRule.getLog());
    }

    @Test
    public void movieSubMenuShouldAskForReturnBookTitleWhenChoosingOptionC(){
        String input = "C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMovieSubMenuChoice();
        assertEquals("What movie would you like to return?\n", systemOutRule.getLog());
    }

    @Test
    public void movieSubMenuShouldDisplayErrorWhenChoosingWrongOption(){
        String input = "L";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMovieSubMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }

    @Test
    public void movieSubMenuShouldExitSystemWhenChoosingOptionD() {
        String input = "D";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMovieSubMenuChoice();
        exit.expectSystemExitWithStatus(0);
    }

    @Test
    public void shouldDisplayMovieSuccessMessageIfMovieCheckedOut(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.checkOutMovie();
        assertEquals("Thank you! Enjoy the movie!\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayMovieFailureMessageIfMovieUnavailable(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.checkOutMovie();
        assertEquals("Sorry, that movie is not available!\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayMovieSuccessMessageIfMovieReturned(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, false);
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.returnMovie();
        assertEquals("Thank you for returning the movie\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayMovieFailureMessageIfNotReturned(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, false);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.returnMovie();
        assertEquals("That is not a valid movie to return\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }
}
