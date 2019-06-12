package com.twu.methods;
import com.twu.objects.User;
import org.junit.Test;
import org.junit.Rule;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class manageLoginTests {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void clearLog(){
        systemOutRule.clearLog();}

    @Test
    public void whenLoginShouldAskForUserId(){
        manageLogin.requestUsername();
        assertEquals("What is your user id?\n", systemOutRule.getLog());
    }

    @Test
    public void whenLoginShouldAskForPassword(){
        manageLogin.requestPassword();
        assertEquals("What is your password?\n", systemOutRule.getLog());
    }

    @Test
    public void whenLoginShouldSaveAttemptedUserID(){
        String input = "4444-666666";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(manageLogin.getTestUserId(), is("4444-666666"));
    }

    @Test
    public void whenLoginShouldSaveAttemptedPassword(){
        String password = "Hola";
        InputStream in = new ByteArrayInputStream(password.getBytes());
        System.setIn(in);
        assertThat(manageLogin.getTestPassword(), is("Hola"));
    }

    @Test
    public void ifUserDoesNotExistShouldReturnError(){
        User user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        String input = "4444-666666";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageLogin.getTestUserId();
        manageLogin.compareUserId();
        assertEquals("That user does not exist!\n", systemOutRule.getLog());
    }

    @Test
    public void ifPasswordIsIncorrectShouldReturnError(){
        User user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        String input = "5555-666666";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageLogin.getTestUserId();
        String password = "5555-666666";
        InputStream ps = new ByteArrayInputStream(password.getBytes());
        System.setIn(ps);
        manageLogin.getTestPassword();
        manageLogin.comparePassword();
        assertEquals("Wrong password!\n", systemOutRule.getLog());
    }

    @Test
    public void ifPasswordIsCorrectShouldDisplayMainMenu(){
        User user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        String input = "5555-666666";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        manageLogin.getTestUserId();
        String password = "Hola";
        InputStream ps = new ByteArrayInputStream(password.getBytes());
        System.setIn(ps);
        manageLogin.getTestPassword();
        manageLogin.comparePassword();
        assertEquals("Please choose one of the following options:\n" +
                "A: Books\n" + "B: Movies\n" + "C: Profile\n" + "D: Exit\n", systemOutRule.getLog());

    }



}
