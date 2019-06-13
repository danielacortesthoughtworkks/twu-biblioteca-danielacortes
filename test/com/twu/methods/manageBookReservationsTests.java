package com.twu.methods;
import com.twu.objects.Book;
import com.twu.objects.User;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;


public class manageBookReservationsTests {
    private User user;
    private manageBookMenu menu;
    private manageBooks bookManager;
    private manageMainMenu mainMenu;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void clearLog(){
        systemOutRule.clearLog();
        user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        menu = new manageBookMenu(user, mainMenu);
       bookManager = new manageBooks(user, menu);
    }

    @Test
    public void whenAskedForBookReservationListShouldShowTitleOfBookAndWhoCheckedItOut() {
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        String title = book.getTitle();
        String input = "Maleficio";
        String name = user.getName();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.checkOutBook();
        manageBookReservations.showAllBookReservations();
        assertEquals("Thank you! Enjoy the book!\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                + title + "|" + name + "\n", systemOutRule.getLog());
    }

}