package com.twu.objects;

public class Message {

    public final void welcome() {
        String welcomeMessage = "Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public final void menu() {
        String menuMessage = "Please choose one of the following options:\n" +
                                "1: List of available books";
        System.out.println(menuMessage);
    }
}
