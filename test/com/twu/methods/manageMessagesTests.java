package com.twu.methods;
import com.twu.objects.Book;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Before;
import java.util.InputMismatchException;


import org.junit.contrib.java.lang.system.SystemOutRule;


public class manageMessagesTests {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private manageMessages manageMessages;

    @Before
    public void createMessage(){
        systemOutRule.clearLog();
        manageMessages = new manageMessages();
    }

    @Test
    public void shouldPrintWelcomeMessageInConsole(){
        manageMessages.welcome();
        assertEquals("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!\n", systemOutRule.getLog());

    }

    @Test
    public void shouldPrintMainMenuinConsole(){
        manageMessages.mainMenu();
        assertEquals("Please choose one of the following options:\n" +
                "1: Books\n", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldDisplayBookSubMenuWhenChoosingOptionOne(){
        int input = 1;
        String inputString = Integer.toString(input);
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
        assertEquals("Please choose one of the following options:\n" +
                "1: Book List\n", systemOutRule.getLog());
    }

    @Test
    public void mainMenuShouldDisplayErrorWhenChoosingWrongNumber(){
        int input = 5;
        String inputString = Integer.toString(input);
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }


    @Test(expected = InputMismatchException.class)
    public void mainMenuShouldDisplayErrorWhenChoosingWrongType(){
        String input = "Blabla";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getMainMenuChoice();
    }


    @Test
    public void bookSubMenuShouldDisplayBookListWhenChoosingOptionOne(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        String title = book.getTitle();
        String author = book.getAuthor();
        int year = book.getPublicationYear();
        String title2 = book2.getTitle();
        String author2 = book2.getAuthor();
        int year2 = book2.getPublicationYear();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getBookSubMenuChoice();
        assertEquals(title + "|" + author + "|" + year + "\n" + title2 + "|" + author2 + "|" + year2 + "\n", systemOutRule.getLog());
    }

    @Test
    public void subMenuShouldDisplayErrorWhenChoosingWrongNumber(){
        int input = 5;
        String inputString = Integer.toString(input);
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        manageMessages.getBookSubMenuChoice();
        assertEquals("Please select a valid option!\n", systemOutRule.getLog());
    }


    @Test(expected = InputMismatchException.class)
    public void subMenuShouldDisplayErrorWhenChoosingWrongType(){
        String input = "Blabla";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageMessages.getBookSubMenuChoice();
    }

}
