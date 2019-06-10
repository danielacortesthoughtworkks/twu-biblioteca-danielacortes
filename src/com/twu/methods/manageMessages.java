package com.twu.methods;
import java.util.Scanner;
public class manageMessages {

    enum menuOptions
    {
        A, B, C, D;
    }

    public static void welcome() {
        String welcomeMessage = "Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public static void mainMenu() {
        String menuMessage = "Please choose one of the following options:\n" +
                                "A: Books\n" + "B: Exit";
        System.out.println(menuMessage);
    }

    public static void getMainMenuChoice() {
        Scanner scanMainChoice = new Scanner(System.in);
        while(scanMainChoice.hasNextLine()) {
            String mainChoice = scanMainChoice.nextLine();
            menuOptions option = menuOptions.valueOf(mainChoice.toUpperCase());

            while (option != menuOptions.A && option != menuOptions.B) {
                System.out.println("Please select a valid option!");
                getMainMenuChoice();
            }

            switch (option) {
                case A:
                    showBookSubMenu();
                    break;

                case B:
                    System.exit(0);
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
            menuOptions option = menuOptions.valueOf(choice.toUpperCase());

        while(option != menuOptions.A && option != menuOptions.B && option != menuOptions.C && option != menuOptions.D){
            System.out.println("Please select a valid option!");
            getBookSubMenuChoice();
        }

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


        }

        }
    }


    public static void checkOutSuccess(){
        System.out.println("Thank you! Enjoy the book!");
        showBookSubMenu();
    }

    public static void checkOutError(){
        System.out.println("Sorry, that book is not available!");
        showBookSubMenu();
    }

    public static void returnSuccess(){
        System.out.println("Thank you for returning the book");
        showBookSubMenu();
    }

    public static void returnError(){
        System.out.println("That is not a valid book to return");
        showBookSubMenu();
    }
}
