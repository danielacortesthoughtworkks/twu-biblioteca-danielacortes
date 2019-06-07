package com.twu.biblioteca;
import com.twu.methods.manageMessages;

public class BibliotecaApp {

    public static void main(String [] args) {
        manageMessages welcomeMessage = new manageMessages();
        welcomeMessage.welcome();
        welcomeMessage.mainMenu();
    }
}