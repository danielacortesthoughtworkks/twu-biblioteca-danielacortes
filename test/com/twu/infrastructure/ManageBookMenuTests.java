package com.twu.infrastructure;
import com.twu.model.Book;
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

public class ManageBookMenuTests {


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    private User user;
    private ManageBookMenu menu;
    private ManageBooks bookManager;
    private ManageMainMenu mainMenu;


    @Before
    public void createMessage(){
        systemOutRule.clearLog();
        user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        mainMenu = new ManageMainMenu(user);
        menu = new ManageBookMenu(user, mainMenu);
        bookManager = new ManageBooks(user, menu);

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
        menu.getBookSubMenuChoice();
        assertEquals(title + "|" + author + "|" + year + "\n" + title2 + "|" + author2 + "|" + year2 + "\n"
                + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }

    @Test
    public void bookSubMenuShouldAskForCheckOutBookTitleWhenChoosingOptionB(){
        String input = "B";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getBookSubMenuChoice();
        assertEquals("What book would you like to check out?\n", systemOutRule.getLog());
    }

    @Test
    public void bookSubMenuShouldAskForReturnBookTitleWhenChoosingOptionC(){
        String input = "C";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getBookSubMenuChoice();
        assertEquals("What book would you like to return?\n", systemOutRule.getLog());
    }

    @Test
    public void subMenuShouldDisplayErrorWhenChoosingWrongOption(){
        String input = "L";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getBookSubMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }

    @Test
    public void bookSubMenuShouldExitSystemWhenChoosingOptionD() {
        String input = "D";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        menu.getBookSubMenuChoice();
        exit.expectSystemExitWithStatus(0);
    }

    @Test
    public void shouldDisplayBookSuccessMessageIfBookCheckedOut(){
        systemOutRule.clearLog();
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.checkOutBook();
        assertEquals("Thank you! Enjoy the book!\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookFailureMessageIfBookUnavailable(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.checkOutBook();
        assertEquals("Sorry, that book is not available!\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookSuccessMessageIfBookReturned(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, false);
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.returnBook();
        assertEquals("Thank you for returning the book\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayBookFailureMessageIfNotReturned(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        String input = "Juanito";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.returnBook();
        assertEquals("That is not a valid book to return\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                , systemOutRule.getLog());
    }
}
