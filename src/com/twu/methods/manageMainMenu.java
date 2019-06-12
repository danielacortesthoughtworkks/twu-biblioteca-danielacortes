package com.twu.methods;
import com.twu.objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class manageMainMenu {

    private static User user;
    private String title;

    private static manageBookMenu bookMenu = new manageBookMenu(user);
    private static manageMovieMenu movieMenu = new manageMovieMenu(user);

    private static List<bookReservation> allBookReservations = new ArrayList<bookReservation>();
    private static List<movieReservation> allMovieReservations = new ArrayList<movieReservation>();
    private static List<User> movieReservationUsers = new ArrayList<User>();
    private static List<User> bookReservationUsers = new ArrayList<User>();


    public manageMainMenu(User user) {
       this.user = user;
    }

    public static void addMovieReservationToList(movieReservation reservation) {
        allMovieReservations.add(reservation);
    }

    public static void addBookReservationToList(bookReservation reservation){
        allBookReservations.add(reservation);
    }

    public void mainMenu() {
       showMainMenu();
        getMainMenuChoice();
    }

    public void showMainMenu() {
        String menuMessage = "Please choose one of the following options:\n" +
                "A: Books\n" + "B: Movies\n" + "C: Profile\n" + "D: Exit" ;
        System.out.println(menuMessage);

    }

    public void getMainMenuChoice() {
        Scanner scanMainChoice = new Scanner(System.in);
        while(scanMainChoice.hasNextLine()) {
            String mainChoice = scanMainChoice.nextLine();
            if(!mainChoice.toUpperCase().equals("A") && !mainChoice.toUpperCase().equals("B")
                    && !mainChoice.toUpperCase().equals("C") && !mainChoice.toUpperCase().equals("D")){
                mainChoice = "OTHER";
            }
            manageMessages.menuOptions option = manageMessages.menuOptions.valueOf(mainChoice.toUpperCase());
            switch (option) {
                case A:
                    bookMenu.showBookSubMenu();
                    break;

                case B:
                    movieMenu.showMovieSubMenu();
                    break;

                case C:
                    showUserDetails();
                    break;

                case D:
                    System.exit(0);
                    break;

                case OTHER:
                    System.out.println("Please select a valid option!");
                    getMainMenuChoice();
                    break;
            }
        }
    }

    public void showUserDetails(){
        String name = user.getName();
        String email = user.getEmail();
        int phone = user.getPhone();
        System.out.println(name + "|" + email + "|" + phone);
        showBookReservations();
        showMovieReservations();
    }

    public void showMovieReservations(){
        for (movieReservation reservation : allMovieReservations){
            User reservationUser = reservation.getUser();
            movieReservationUsers.add(user);
            Movie reservationMovie = reservation.getMovie();
            title = reservationMovie.getTitle();
            if(movieReservationUsers.contains(user)){
                System.out.println("These are the movies you have checked out:");
                if (reservationUser.equals(user)){
                    System.out.println(title + "|");
                }
            }
        }

    }

    public void showBookReservations(){
        for (bookReservation reservation : allBookReservations){
            User reservationUser = reservation.getUser();
            bookReservationUsers.add(user);
            Book reservationBook = reservation.getBook();
            title = reservationBook.getTitle();
            if(bookReservationUsers.contains(user)){
                System.out.println("These are the books you have checked out:");
                if (reservationUser.equals(user)){
                    System.out.println(title + "|");
                }
            }
        }

    }

}
