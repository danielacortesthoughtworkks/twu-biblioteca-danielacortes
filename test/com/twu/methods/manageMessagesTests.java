package com.twu.methods;
import com.twu.objects.Book;
import com.twu.objects.Movie;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Before;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.lang.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;


public class manageMessagesTests {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    private manageMessages manageMessages;

    @Before
    public void createMessage(){
        systemOutRule.clearLog();
        manageMessages = new manageMessages();
    }

    @Test
    public void shouldPrintWelcomeMessageInConsole(){
        manageMessages.welcome();
        assertEquals("Welcome to Biblioteca, your one-stop-shop for great book and movie titles in Bangalore!\n", systemOutRule.getLog());
    }

    @Test
    public void shouldPrintMainMenuinConsole(){
        manageMessages.mainMenu();
        assertEquals("Please choose one of the following options:\n" +
                "A: Books\n" + "B: Movies\n" + "C: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldDisplayBookSubMenuWhenChoosingOptionA(){
        String input = "A";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
        assertEquals("Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldDisplayMovieSubMenuWhenChoosingOptionB(){
        String input = "B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
        assertEquals("Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldExitSystemWhenChoosingOptionC() {
        String input = "C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
        exit.expectSystemExitWithStatus(0);
        System.exit(0);
    }

    @Test
    public void mainMenuShouldDisplayErrorWhenChoosingWrongOption(){
        String input = "X";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }

    @Test
    public void bookSubMenuShouldDisplayBookListWhenChoosingOptionA(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        String title = book.getTitle();
        String author = book.getAuthor();
        int year = book.getPublicationYear();
        String title2 = book2.getTitle();
        String author2 = book2.getAuthor();
        int year2 = book2.getPublicationYear();
        String input = "A";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getBookSubMenuChoice();
        assertEquals(title + "|" + author + "|" + year + "\n" + title2 + "|" + author2 + "|" + year2 + "\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void bookSubMenuShouldAskForCheckOutBookTitleWhenChoosingOptionB(){
        String input = "B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getBookSubMenuChoice();
        assertEquals("What book would you like to check out?\n", systemOutRule.getLog());
    }

    @Test
    public void bookSubMenuShouldAskForReturnBookTitleWhenChoosingOptionC(){
        String input = "C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getBookSubMenuChoice();
        assertEquals("What book would you like to return?\n", systemOutRule.getLog());
    }

    @Test
    public void subMenuShouldDisplayErrorWhenChoosingWrongOption(){
        String input = "L";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getBookSubMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }

    @Test
    public void bookSubMenuShouldExitSystemWhenChoosingOptionD() {
        String input = "D";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
        exit.expectSystemExitWithStatus(0);
    }

    @Test
    public void shouldDisplayBookSuccessMessageIfBookCheckedOut(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageBooks.checkOutBook();
        assertEquals("Thank you! Enjoy the book!\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookFailureMessageIfBookUnavailable(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageBooks.checkOutBook();
        assertEquals("Sorry, that book is not available!\n" + "Please choose one of the following options:\n" +
        "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookSuccessMessageIfBookReturned(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, false);
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageBooks.returnBook();
        assertEquals("Thank you for returning the book\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookFailureMessageIfNotReturned(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageBooks.returnBook();
        assertEquals("That is not a valid book to return\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n", systemOutRule.getLog());
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
        manageMessages.getMovieSubMenuChoice();
        assertEquals(title + "|" + director + "|" + year + "|" + rating + "\n" + title2 + "|" + director2 + "|" + year2 + "|" + rating2 + "\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void movieSubMenuShouldAskForCheckOutBookTitleWhenChoosingOptionB(){
        String input = "B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMovieSubMenuChoice();
        assertEquals("What movie would you like to check out?\n", systemOutRule.getLog());
    }

    @Test
    public void movieSubMenuShouldAskForReturnBookTitleWhenChoosingOptionC(){
        String input = "C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMovieSubMenuChoice();
        assertEquals("What movie would you like to return?\n", systemOutRule.getLog());
    }

    @Test
    public void movieSubMenuShouldDisplayErrorWhenChoosingWrongOption(){
        String input = "L";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMovieSubMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }

    @Test
    public void movieSubMenuShouldExitSystemWhenChoosingOptionD() {
        String input = "D";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMovieSubMenuChoice();
        exit.expectSystemExitWithStatus(0);
    }

    @Test
    public void shouldDisplayMovieSuccessMessageIfMovieCheckedOut(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMovies.checkOutMovie();
        assertEquals("Thank you! Enjoy the movie!\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookFailureMessageIfMovieUnavailable(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMovies.checkOutMovie();
        assertEquals("Sorry, that movie is not available!\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookSuccessMessageIfMovieReturned(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, false);
        String input = "Gone with the wind";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMovies.returnMovie();
        assertEquals("Thank you for returning the movie\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n", systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayMovieFailureMessageIfNotReturned(){
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, false);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMovies.returnMovie();
        assertEquals("That is not a valid movie to return\n" + "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n", systemOutRule.getLog());
    }
}
