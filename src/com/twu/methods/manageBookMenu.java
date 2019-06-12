package com.twu.methods;

import com.twu.objects.User;

import java.util.Scanner;

public class manageBookMenu {

    private static User user;
    private static manageBooks bookManager = new manageBooks(user);

    public manageBookMenu(User user) {
        this.user = user;
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
            if(!choice.toUpperCase().equals("A") && !choice.toUpperCase().equals("B") &&
                    !choice.toUpperCase().equals("C") && !choice.toUpperCase().equals("D")){
                choice = "OTHER";
            }
            manageMessages.menuOptions option = manageMessages.menuOptions.valueOf(choice.toUpperCase());

            switch(option){
                case A:
                    bookManager.showAvailableBooks();
                    showBookSubMenu();
                    break;
                case B:
                    System.out.println("What book would you like to check out?");
                    bookManager.checkOutBook();
                    break;
                case C:
                    System.out.println("What book would you like to return?");
                    bookManager.returnBook();
                    break;

                case D:
                    System.exit(0);
                    break;

                case OTHER:
                    System.out.println("Please select a valid option!");
                    getBookSubMenuChoice();
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
}
