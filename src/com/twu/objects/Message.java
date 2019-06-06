package com.twu.objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Message {

    public final void welcome() {
        String welcomeMessage = "Welcome to Biblioteca, your one-stop-shop for great book titles in Bangalore!";
        System.out.println(welcomeMessage);
    }

    public final void menu() {
        String menuMessage = "Please choose one of the following options:\n" +
                                "1: List of available books";
        System.out.println(menuMessage);
    }

    public static void getChoice() {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice == 1 ){
           Book.showAvailableBooks();
         }
        else{
            System.out.println("Por favor ingresa un número del 1 al 1");
        }
    }
}