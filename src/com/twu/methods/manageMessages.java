package com.twu.methods;
import java.util.Scanner;
public class manageMessages {

    public static void welcome() {
        String welcomeMessage = "Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public static void mainMenu() {
        String menuMessage = "Please choose one of the following options:\n" +
                                "1: Books\n" + "2:Exit";
        System.out.println(menuMessage);
    }

    public static void getMainMenuChoice() {
        Scanner scanMainChoice = new Scanner(System.in);
        if(scanMainChoice.hasNextInt());
        int mainChoice = scanMainChoice.nextInt();

        while(mainChoice < 1 || mainChoice > 2){
            System.out.println("Please select a valid option!");
           getMainMenuChoice();
        }

        switch(mainChoice) {
            case 1:
                showBookSubMenu();
                break;

            case 2:
                System.exit(0);
        }

    }

    public static void showBookSubMenu(){
        String menuMessage = "Please choose one of the following options:\n" +
                "1: Book List\n" + "2: Check out Book\n" + "3: Return book\n" + "4: Exit";
        System.out.println(menuMessage);
        getBookSubMenuChoice();
    }

    public static void getBookSubMenuChoice() {
        Scanner scanChoice = new Scanner(System.in);
        if(scanChoice.hasNextInt());
           int choice = scanChoice.nextInt();

        while(choice < 1 || choice > 4){
            System.out.println("Please select a valid option!");
            getBookSubMenuChoice();
        }

        switch(choice){
            case 1:
                manageBooks.showAvailableBooks();
                showBookSubMenu();
                break;
            case 2:
                System.out.println("What book would you like to check out?");
                Scanner scan = new Scanner(System.in);
                String bookChoice = scan.nextLine();
                manageBooks.checkOutBook(bookChoice);
                showBookSubMenu();
                break;
            case 3:
                System.out.println("What book would you like to return?");
                Scanner scanner = new Scanner(System.in);
                String returnChoice = scanner.nextLine();
                manageBooks.returnBook(returnChoice);
                showBookSubMenu();
                break;

            case 4:
                System.exit(0);


        }

        }

    public static void checkOutSuccess(){
        System.out.println("Thank you! Enjoy the book!");
    }

    public static void checkOutError(){
        System.out.println("That book is not available!");
    }
}
