package com.twu.methods;
import com.twu.objects.bookReservation;
import com.twu.objects.movieReservation;
import com.twu.objects.Book;
import com.twu.objects.Movie;
import com.twu.objects.User;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Before;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.lang.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class manageMainMenuTests {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private User user;
    private manageMainMenu menu;
    private Movie movie;
    private Book book;
    private movieReservation movieReservation;
    private bookReservation bookReservation;


    @Before
    public void createMessage(){
        systemOutRule.clearLog();
        movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        menu = new manageMainMenu(user);
    }

    @Test
    public void shouldPrintMainMenuinConsole(){
        menu.mainMenu();
        assertEquals("Please choose one of the following options:\n" +
                "A: Books\n" + "B: Movies\n" + "C: Profile\n" + "D: Exit", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldDisplayBookSubMenuWhenChoosingOptionA(){
        String input = "A";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMainMenuChoice();
        assertEquals("Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldDisplayMovieSubMenuWhenChoosingOptionB(){
        String input = "B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMainMenuChoice();
        assertEquals("Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldDisplayUserDetailsWhenChoosingOptionC(){
        String name = user.getName();
        String email = user.getEmail();
        int phone = user.getPhone();
        String input = "C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMainMenuChoice();
        assertEquals(name + "|" + email + "|" + phone + "\n", systemOutRule.getLog());
    }


    @Test
    public void userProfileShouldListCheckedOutMoviesAndBooks() {
        String name = user.getName();
        String email = user.getEmail();
        int phone = user.getPhone();
        String movieTitle = movie.getTitle();
        String bookTitle = book.getTitle();
        movieReservation = new movieReservation(movie, user);
        bookReservation = new bookReservation(book, user);
        menu.showUserDetails();
        assertEquals(name + "|" + email + "|" + phone + "\n" +
                "These are the books you have checked out:\n" + bookTitle + "|" + "\n" +
                "These are the movies you have checked out:\n" + movieTitle + "|" + "\n"
                , systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldExitSystemWhenChoosingOptionD() {
        String input = "D";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getMainMenuChoice();
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }

    @Test
    public void mainMenuShouldDisplayErrorWhenChoosingWrongOption(){
        String input = "X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
       menu.getMainMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }


}
