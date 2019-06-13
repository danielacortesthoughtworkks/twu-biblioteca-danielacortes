package com.twu.infrastructure;
import com.twu.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageMainMenu {

    private User user;
    private String title;
    private static List<BookReservation> allBookReservations = new ArrayList<BookReservation>();
    private static List<MovieReservation> allMovieReservations = new ArrayList<MovieReservation>();
    private static List<User> movieReservationUsers = new ArrayList<User>();
    private static List<User> bookReservationUsers = new ArrayList<User>();


    public ManageMainMenu(User user) {
       this.user = user;
    }




    public static void addMovieReservationToList(MovieReservation reservation) {
        allMovieReservations.add(reservation);
    }

    public static void addBookReservationToList(BookReservation reservation){
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
        User testuser = user;
        Scanner scanMainChoice = new Scanner(System.in);
        while(scanMainChoice.hasNextLine()) {
            String mainChoice = scanMainChoice.nextLine();

            if(!mainChoice.toUpperCase().equals("A") && !mainChoice.toUpperCase().equals("B")
                    && !mainChoice.toUpperCase().equals("C") && !mainChoice.toUpperCase().equals("D")){
                mainChoice = "OTHER";
            }
            ManageMessages.menuOptions option = ManageMessages.menuOptions.valueOf(mainChoice.toUpperCase());
            switch (option) {
                case A:
                    ManageBookMenu bookMenu = new ManageBookMenu(testuser,this);
                    bookMenu.showBookSubMenu();
                    break;

                case B:
                    ManageMovieMenu movieMenu = new ManageMovieMenu(testuser, this);
                    movieMenu.showMovieSubMenu();
                    break;

                case C:
                    this.showUserDetails();
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
        try{
            String name = user.getName();
            String email = user.getEmail();
            int phone = user.getPhone();
            System.out.println(name + "|" + email + "|" + phone);
            showBookReservations();
            showMovieReservations();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void showMovieReservations(){
        for (MovieReservation reservation : allMovieReservations){
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
        for (BookReservation reservation : allBookReservations){
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
