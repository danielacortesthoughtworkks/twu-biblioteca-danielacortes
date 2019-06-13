package com.twu.methods;
import com.twu.objects.Movie;
import com.twu.objects.User;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;


public class manageMovieReservationsTests {
    private User user;
    private manageMainMenu mainMenu;
    private manageMovieMenu menu;
    private manageMovies movieManager;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void clearLog(){
        systemOutRule.clearLog();
        user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        mainMenu = new manageMainMenu(user);
        menu = new manageMovieMenu(user, mainMenu);
        movieManager = new manageMovies(user, menu);
    }

    @Test
    public void whenAskedForMovieReservationListShouldShowTitleOfMovieAndWhoCheckedItOut() {
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        Movie movie2 = new Movie (2, "Empire Records", "Ethan Embry", 1996, 10, true);
        String title = movie.getTitle();
        String input = "Gone with the wind";
        String name = user.getName();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.checkOutMovie();
        manageMovieReservations.showAllMovieReservations();
        assertEquals("Thank you! Enjoy the movie!\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + "E: Main Menu\n"
                + title + "|" + name + "\n", systemOutRule.getLog());
    }
}
