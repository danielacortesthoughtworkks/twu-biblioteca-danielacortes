package com.twu.methods;
import com.twu.objects.User;
import java.util.Scanner;

public class manageMovieMenu {
    private User user;
    private manageMainMenu menu;

    public manageMovieMenu(User user, manageMainMenu menu) {
        this.user = user;
        this.menu = menu;
    }


    public  void showMovieSubMenu(){
        String menuMessage = "Please choose one of the following options:\n" +
                "A: Movie List\n" + "B: Check out Movie\n" + "C: Return Movie\n" + "D: Exit\n" + "E: Main Menu";
        System.out.println(menuMessage);
        getMovieSubMenuChoice();
    }

    public void getMovieSubMenuChoice() {
        User testUser = user;
        manageMovies movieManager = new manageMovies(testUser, this);
        Scanner scanMovieMenuChoice = new Scanner(System.in);
        while(scanMovieMenuChoice.hasNextLine()) {
            String choiceMovieMenu = scanMovieMenuChoice.nextLine();
            if(!choiceMovieMenu.toUpperCase().equals("A") && !choiceMovieMenu.toUpperCase().equals("B") &&
                    !choiceMovieMenu.toUpperCase().equals("C") && !choiceMovieMenu.toUpperCase().equals("D")
            && !choiceMovieMenu.toUpperCase().equals("E")){
                choiceMovieMenu = "OTHER";
            }
            manageMessages.menuOptions option = manageMessages.menuOptions.valueOf(choiceMovieMenu.toUpperCase());

            switch(option){
                case A:
                    movieManager.showAvailableMovies();
                    showMovieSubMenu();
                    break;
                case B:
                    System.out.println("What movie would you like to check out?");
                   movieManager.checkOutMovie();
                    break;
                case C:
                    System.out.println("What movie would you like to return?");
                    movieManager.returnMovie();
                    break;

                case D:
                    System.exit(0);
                    break;

                case E:
                    manageMainMenu menu = new manageMainMenu(user);
                    menu.mainMenu();

                case OTHER:
                    System.out.println("Please select a valid option!");
                    getMovieSubMenuChoice();
                    break;
            }
        }
    }

    public void movieCheckOutSuccess(){
        System.out.println("Thank you! Enjoy the movie!");
        showMovieSubMenu();
    }

    public void movieCheckOutError(){
        System.out.println("Sorry, that movie is not available!");
        showMovieSubMenu();
    }

    public void movieReturnSuccess(){
        System.out.println("Thank you for returning the movie");
        showMovieSubMenu();
    }

    public void movieReturnError(){
        System.out.println("That is not a valid movie to return");
        showMovieSubMenu();
    }
}
