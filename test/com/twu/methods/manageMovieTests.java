package com.twu.methods;
import com.twu.objects.Movie;
import com.twu.objects.User;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class manageMovieTests {

    private User user;
    private manageMovieMenu menu;
    private manageMovies movieManager;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void clearLog(){
        systemOutRule.clearLog();
        user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        menu = new manageMovieMenu(user);
        movieManager = new manageMovies(user);
    }

    @Test
    public void shouldListOnlyAvailableMovies(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        Movie movie2 = new Movie (2, "Empire Records", "Ethan Embry", 1996, 10, true);
        Movie movie3 = new Movie (1, "Hola hola", "Playa beach", 1994, 5, false);
        String title = movie.getTitle();
        String author = movie.getDirector();
        int year = movie.getYear();
        int rating = movie.getRating();
        String title2 = movie2.getTitle();
        String author2 = movie2.getDirector();
        int year2 = movie2.getYear();
        int rating2 = movie2.getRating();
        movieManager.showAvailableMovies();
        assertEquals(title + "|" + author + "|" + year + "|" + rating + "\n" + title2 + "|" + author2 + "|" + year2 + "|" + rating2 + "\n", systemOutRule.getLog());
    }

    @Test
    public void shouldChangeAvailabilityOfCheckedOutMovie(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.checkOutMovie();
        boolean availabilty = movie.getAvailable();
        assertThat(availabilty, is(false));
    }

    @Test
    public void checkedOutMovieShouldNotAppearInList(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        Movie movie2 = new Movie (2, "Empire Records", "Ethan Embry", 1996, 10, true);
        String title2 = movie2.getTitle();
        String director2 = movie2.getDirector();
        int year2 = movie2.getYear();
        int rating2 = movie2.getRating();
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.checkOutMovie();
        movieManager.showAvailableMovies();
        assertEquals("Thank you! Enjoy the movie!\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + title2 + "|" + director2 + "|" + year2 + "|" + rating2 + "\n", systemOutRule.getLog());
    }

    @Test
    public void shouldChangeAvailabilityOfReturnedMovie(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, false);
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.returnMovie();
        boolean availabilty = movie.getAvailable();
        assertThat(availabilty, is(true));
    }

    @Test
    public void returnedMovieShouldAppearInList(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, false);
        Movie movie2 = new Movie (2, "Empire Records", "Ethan Embry", 1996, 10, true);
        String title = movie.getTitle();
        String director = movie.getDirector();
        int year = movie.getYear();
        int rating = movie.getRating();
        String title2 = movie2.getTitle();
        String director2 = movie2.getDirector();
        int year2 = movie2.getYear();
        int rating2 = movie2.getRating();
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        movieManager.returnMovie();
        movieManager.showAvailableMovies();
        assertEquals("Thank you for returning the movie\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n"  + title + "|" + director + "|" + year + "|" + rating + "\n" + title2 + "|" + director2 + "|" + year2 + "|" + rating2 + "\n", systemOutRule.getLog());
    }
}
