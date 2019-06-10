package com.twu.methods;
import com.twu.objects.Book;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

public class manageBooksTests {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void createBooks(){
        systemOutRule.clearLog();
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
        manageBooks.showAvailableBooks();
        assertEquals(title + "|" + author + "|" + year + "\n" + title2 + "|" + author2 + "|" + year2 + "\n", systemOutRule.getLog());
    }

    @Test
    public void shouldChangeAvailabilityOfCheckedOutBook(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        manageBooks.checkOutBook("Maleficio");
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
        manageBooks.checkOutBook("Maleficio");
        manageBooks.showAvailableBooks();
        assertEquals("Thank you! Enjoy the book!\n" + title2 + "|" + author2 + "|" + year2 + "\n", systemOutRule.getLog());
    }

    @Test
    public void shouldChangeAvailabilityofReturnedBook(){
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, false);
        manageBooks.returnBook("Maleficio");
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
        manageBooks.returnBook("Maleficio");
        manageBooks.showAvailableBooks();
        assertEquals(title + "|" + author + "|" + year + "\n" + title2 + "|" + author2 + "|" + year2 + "\n", systemOutRule.getLog());
    }
    }