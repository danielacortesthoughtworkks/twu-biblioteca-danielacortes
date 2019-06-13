package com.twu.methods;
import com.twu.objects.Book;
import com.twu.objects.User;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class manageBooksTests {

    private User user;
    private manageMainMenu mainMenu;
    private manageBookMenu menu;
    private manageBooks bookManager;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void clearLog(){
        systemOutRule.clearLog();
        user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com",
                79298644);
        mainMenu = new manageMainMenu(user);
        menu = new manageBookMenu(user, mainMenu);
        bookManager = new manageBooks(user, menu);

    }

    @Test
    public void shouldListOnlyAvailableBooks(){
       Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
       Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
       Book book3 = new Book(3, "Hijos de la ira", "Andrés Urrutia", 1893, false);
        String title = book.getTitle();
        String author = book.getAuthor();
        int year = book.getPublicationYear();
        String title2 = book2.getTitle();
        String author2 = book2.getAuthor();
        int year2 = book2.getPublicationYear();
        bookManager.showAvailableBooks();
        assertEquals(title + "|" + author + "|" + year + "\n" + title2 + "|" + author2 + "|" + year2 + "\n", systemOutRule.getLog());
    }

    @Test
    public void shouldChangeAvailabilityOfCheckedOutBook(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.checkOutBook();
        boolean availabilty = book.getAvailable();
        assertThat(availabilty, is(false));
    }

    @Test
    public void checkedOutBookShouldNotAppearInList(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        String title2 = book2.getTitle();
        String author2 = book2.getAuthor();
        int year2 = book2.getPublicationYear();
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.checkOutBook();
        bookManager.showAvailableBooks();
        assertEquals("Thank you! Enjoy the book!\n" +  "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                + title2 + "|" + author2 + "|" + year2 + "\n", systemOutRule.getLog());
    }

    @Test
    public void shouldChangeAvailabilityofReturnedBook(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, false);
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.returnBook();
        boolean availabilty = book.getAvailable();
        assertThat(availabilty, is(true));
    }

    @Test
    public void returnedBookShouldAppearInList(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, false);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        String title = book.getTitle();
        String author = book.getAuthor();
        int year = book.getPublicationYear();
        String title2 = book2.getTitle();
        String author2 = book2.getAuthor();
        int year2 = book2.getPublicationYear();
        String input = "Maleficio";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        bookManager.returnBook();
        bookManager.showAvailableBooks();
        assertEquals("Thank you for returning the book\n" + "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit\n" + "E: Main Menu\n"
                + title + "|" + author + "|" + year + "\n" + title2 + "|" + author2 + "|" + year2 + "\n", systemOutRule.getLog());
    }
}