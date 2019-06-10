package com.twu.biblioteca;
import com.twu.methods.manageMessages;
import com.twu.objects.Book;
import java.util.Scanner;
public class BibliotecaApp {
    static Scanner scan;
    private static int choice;

    public static void main(String [] args) {
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        Book book3 = new Book(3, "Hijos de la ira", "Andrés Urrutia", 1893, false);
        manageMessages.welcome();
        manageMessages.mainMenu();
        manageMessages.getMainMenuChoice();
    }
}
