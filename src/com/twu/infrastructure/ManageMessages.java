package com.twu.infrastructure;
public class ManageMessages {

    enum menuOptions
    {
        A, B, C, D, E, OTHER;
    }

    public static void welcome() {
        String welcomeMessage = "Welcome to Biblioteca, your one-stop-shop for great book and movie titles in Bangalore!";
        System.out.println(welcomeMessage);
    }


}
