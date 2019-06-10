package com.twu.methods;
import java.util.Scanner;
public class manageMessages {

    enum menuOptions
    {
        A, B, C, D, OTHER;
    }

    public static void welcome() {
        String welcomeMessage = "Welcome to Biblioteca, your one-stop-shop for great book and movie titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public static void mainMenu() {
        String menuMessage = "Please choose one of the following options:\n" +
                                "A: Books\n" + "B: Movies\n" + "C: Exit" ;
        System.out.println(menuMessage);
    }

    public static void getMainMenuChoice() {
        Scanner scanMainChoice = new Scanner(System.in);
        while(scanMainChoice.hasNextLine()) {
            String mainChoice = scanMainChoice.nextLine();
            if(!mainChoice.toUpperCase().equals("A") && !mainChoice.toUpperCase().equals("B") && !mainChoice.toUpperCase().equals("C")){
                mainChoice = "OTHER";
            }
            menuOptions option = menuOptions.valueOf(mainChoice.toUpperCase());
            switch (option) {
                case A:
                    showBookSubMenu();
                    break;

                case B:
                    showMovieSubMenu();
                    break;


                case C:
                    System.exit(0);
                    break;

                case OTHER:
                    System.out.println("Please select a valid option!");
                    getMainMenuChoice();
                    break;
            }
        }
    }

    public static void showBookSubMenu(){
        String menuMessage = "Please choose one of the following options:\n" +
                "A: Book List\n" + "B: Check out Book\n" + "C: Return Book\n" + "D: Exit";
        System.out.println(menuMessage);
        getBookSubMenuChoice();
    }

    public static void getBookSubMenuChoice() {
        Scanner scanChoice = new Scanner(System.in);
        while(scanChoice.hasNextLine()) {
            String choice = scanChoice.nextLine();
            if(!choice.toUpperCase().equals("A") && !choice.toUpperCase().equals("B") && !choice.toUpperCase().equals("C") && !choice.toUpperCase().equals("D")){
                choice = "OTHER";
            }
            menuOptions option = menuOptions.valueOf(choice.toUpperCase());

            switch(option){
                case A:
                    manageBooks.showAvailableBooks();
                    showBookSubMenu();
                    break;
                case B:
                    System.out.println("What book would you like to check out?");
                    manageBooks.checkOutBook();
                    break;
                case C:
                    System.out.println("What book would you like to return?");
                    manageBooks.returnBook();
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

    public static void bookCheckOutSuccess(){
        System.out.println("Thank you! Enjoy the book!");
        showBookSubMenu();
    }

    public static void bookCheckOutError(){
        System.out.println("Sorry, that book is not available!");
        showBookSubMenu();
    }

    public static void bookReturnSuccess(){
        System.out.println("Thank you for returning the book");
        showBookSubMenu();
    }

    public static void bookReturnError(){
        System.out.println("That is not a valid book to return");
        showBookSubMenu();
    }


    public static void showMovieSubMenu(){
        String menuMessage = "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit";
        System.out.println(menuMessage);
        getMovieSubMenuChoice();
    }

    public static void getMovieSubMenuChoice() {
        Scanner scanMovieMenuChoice = new Scanner(System.in);
        while(scanMovieMenuChoice.hasNextLine()) {
            String choiceMovieMenu = scanMovieMenuChoice.nextLine();
            if(!choiceMovieMenu.toUpperCase().equals("A") && !choiceMovieMenu.toUpperCase().equals("B") && !choiceMovieMenu.toUpperCase().equals("C") && !choiceMovieMenu.toUpperCase().equals("D")){
                choiceMovieMenu = "OTHER";
            }
            menuOptions option = menuOptions.valueOf(choiceMovieMenu.toUpperCase());

            switch(option){
                case A:
                    manageMovies.showAvailableMovies();
                    showMovieSubMenu();
                    break;
                case B:
                    System.out.println("What movie would you like to check out?");
                    manageMovies.checkOutMovie();
                    break;
                case C:
                    System.out.println("What movie would you like to return?");
                    manageMovies.returnMovie();
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

    public static void movieCheckOutSuccess(){
        System.out.println("Thank you! Enjoy the movie!");
        showBookSubMenu();
    }

    public static void movieCheckOutError(){
        System.out.println("Sorry, that movie is not available!");
        showBookSubMenu();
    }

    public static void movieReturnSuccess(){
        System.out.println("Thank you for returning the movie");
        showBookSubMenu();
    }

    public static void movieReturnError(){
        System.out.println("That is not a valid movie to return");
        showBookSubMenu();
    }
}
