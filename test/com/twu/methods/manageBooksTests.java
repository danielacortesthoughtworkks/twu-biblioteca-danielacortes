package com.twu.methods;
import com.twu.objects.Book;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

public class manageBooksTests {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void createMessage(){
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
    @Ignore
    @Test
    public void shouldChangeIdAfterSettingUniqueID(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        manageBooks.setUniqueId(book);
        double bookIndex = book.getIndex();
        assertThat(bookIndex, is(not(1.0)));
    }

    @Test
    public void checkedoutBookShouldNotAppearInList(){

    }

    @Test
    public void shouldChangeAvailabilityOfCheckedOutBook(){

    }
}