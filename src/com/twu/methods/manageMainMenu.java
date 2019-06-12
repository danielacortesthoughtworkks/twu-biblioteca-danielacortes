package com.twu.methods;
import com.twu.objects.User;
import java.util.Scanner;
public class manageMainMenu {

    private static User user;
    private static manageBookMenu bookMenu = new manageBookMenu(user);
    private static manageMovieMenu movieMenu = new manageMovieMenu(user);


    public manageMainMenu(User user) {
       this.user = user;
    }

    public static void mainMenu() {
        String menuMessage = "Please choose one of the following options:\n" +
                "A: Books\n" + "B: Movies\n" + "C: Profile\n" + "D: Exit" ;
        System.out.println(menuMessage);
        getMainMenuChoice();
    }

    public static void getMainMenuChoice() {
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
                    manageBookMenu bookMenu = new manageBookMenu(user);
                    bookMenu.showBookSubMenu();
                    break;

                case B:
                    manageMovieMenu movieMenu = new manageMovieMenu(user);
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

    public static void showUserDetails(){
        String name = user.getName();
        String email = user.getEmail();
        int phone = user.getPhone();
        System.out.println(name + "|" + email + "|" + phone);
    }
}
