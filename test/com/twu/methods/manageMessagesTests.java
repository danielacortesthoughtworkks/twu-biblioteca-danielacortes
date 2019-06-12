package com.twu.methods;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
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
        assertEquals("Welcome to Biblioteca, your one-stop-shop for great book and movie titles in Bangalore!\n", systemOutRule.getLog());
    }

}
