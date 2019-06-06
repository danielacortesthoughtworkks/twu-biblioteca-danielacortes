package com.twu.objects;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.Before;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;


import org.junit.contrib.java.lang.system.SystemOutRule;


public class MessageTests {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    private Message message;

    @Before
    public void createMessage(){
        systemOutRule.clearLog();
        message = new Message();
    }

    @Test
    public void shouldPrintWelcomeMessageInConsole(){
        message.welcome();
        assertEquals("Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!\n", systemOutRule.getLog());

    }

    @Test
    public void shouldPrintMenuinConsole(){
        message.menu();
        assertEquals("Please choose one of the following options:\n" +
                "1: List of available books\n", systemOutRule.getLog());
    }

    @Test
    public void shouldDisplayErrorWhenChoosingWrongNumber(){
        int input = 5;
        String inputString = Integer.toString(input);
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
        message.getChoice();
        assertEquals("Por favor ingresa un número del 1 al 1\n", systemOutRule.getLog());
    }


    @Test(expected = InputMismatchException.class)
    public void shouldDisplayErrorWhenChoosingWrongType(){
        String input = "Blabla";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        message.getChoice();
    }


    @Test
    public void shouldShowBookListWhenChoosingOptionOne(){
        List<Book> availableBooks = new ArrayList<Book>();
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        availableBooks.add(book);
        availableBooks.add(book2);
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        message.getChoice();
        assertEquals(availableBooks.toString() + "\n", systemOutRule.getLog());
    }
}
