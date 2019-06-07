package com.twu.methods;
import com.twu.methods.manageBooks;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manageMessages {

    public final void welcome() {
        String welcomeMessage = "Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public final void mainMenu() {
        String menuMessage = "Please choose one of the following options:\n" +
                                "1: Books";
        System.out.println(menuMessage);
    }

    public static void getMainMenuChoice() {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice == 1 ){
            showBookSubMenu();
        }
        else{
            System.out.println("Please select a valid option!");
        }
    }

    public static void getBookSubMenuChoice() {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice == 1 ){
           manageBooks.showAvailableBooks();
         }
        else{
            System.out.println("Please select a valid option!");
        }
    }

    public static void showBookSubMenu(){
        String menuMessage = "Please choose one of the following options:\n" +
                "1: Book List";
        System.out.println(menuMessage);

    }
}
