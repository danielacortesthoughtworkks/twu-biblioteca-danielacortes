package com.twu.infrastructure;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.contrib.java.lang.system.SystemOutRule;



public class ManageMessagesTests {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
    private ManageMessages manageMessages;



    @Before
    public void createMessage(){
        systemOutRule.clearLog();
        manageMessages = new ManageMessages();
    }

    @Test
    public void shouldPrintWelcomeMessageInConsole(){
        manageMessages.welcome();
        assertEquals("Welcome to Biblioteca, your one-stop-shop for great book and movie titles in Bangalore!\n", systemOutRule.getLog());
    }

}
