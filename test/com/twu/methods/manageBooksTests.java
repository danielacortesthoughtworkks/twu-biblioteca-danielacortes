package com.twu.methods;
import com.twu.objects.Book;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.util.ArrayList;
import java.util.List;
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
        List<Book> availableBooks = new ArrayList<Book>();
        availableBooks.add(book);
        availableBooks.add(book2);
        manageBooks.showAvailableBooks();
        assertEquals(availableBooks.toString() + "\n", systemOutRule.getLog());
    }
    @Ignore
    @Test
    public void shouldChangeIdAfterSettingUniqueID(){
        Book book = new Book(1.0, "Maleficio", "Claudia Andrade", 1994, true);
        manageBooks.setUniqueId(book);
        double bookIndex = book.getIndex();
        assertThat(bookIndex, is(not(1.0)));
    }
}