package com.twu.objects;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookTests {
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
        Book.showAvailableBooks();
        assertEquals(availableBooks.toString() + "\n", systemOutRule.getLog());
    }




}
