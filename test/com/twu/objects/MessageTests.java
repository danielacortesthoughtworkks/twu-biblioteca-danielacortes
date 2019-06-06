package com.twu.objects;
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

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
    public void shouldDisplayErrorWhenChoosingUnavailableOption(){
        message.menu()
    }
}
