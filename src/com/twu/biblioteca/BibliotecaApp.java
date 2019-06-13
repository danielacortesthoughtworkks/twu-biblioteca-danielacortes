package com.twu.biblioteca;
import com.twu.methods.manageMessages;
import com.twu.objects.Book;
import com.twu.objects.Movie;
import com.twu.methods.manageLogin;
import com.twu.objects.User;

public class BibliotecaApp {

    public static void main(String [] args) {
        Book book = new Book(1, "Maleficio", "Claudia Andrade", 1994, true);
        Book book2 = new Book(2, "Calíope", "J.L Flores", 1970, true);
        Book book3 = new Book(3, "Hijos de la ira", "Andrés Urrutia", 1893, false);
        Movie movie = new Movie (1, "Gone with the wind", "Juanito Perez", 1994, 5, true);
        Movie movie2 = new Movie (2, "Empire Records", "Ethan Embry", 1996, 10, true);
        Movie movie3 = new Movie (1, "Hola hola", "Playa beach", 1994, 5, false);
        User user = new User("5555-666666", "Daniela Cortés", "Hola", "dustyglass@gmail.com", 79298644);
        manageMessages.welcome();
        manageLogin.validatePassword();
    }

}
