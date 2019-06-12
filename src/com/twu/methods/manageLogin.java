package com.twu.methods;
import com.twu.objects.User;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class manageLogin {

    private static String testUserId;
    private static String testPassword;
    private static User user;
    private static String userId;
    private static String password;
    private static boolean usernameSuccess;

    private static List<User> allUsers = new ArrayList<User>();
    private static List<String> userIDs = new ArrayList<String>();

    public static void addUserToList(User user) {
        allUsers.add(user);
    }

    public static void validatePassword() {
        requestUsername();
        getTestUserId();
        compareUserId();
    }

    public static void requestUsername() {
        System.out.println("What is your user id?");
    }

    public static String getTestUserId() {
        Scanner scanId = new Scanner(System.in);
        testUserId = scanId.nextLine();
        return testUserId;
    }

    public static void compareUserId(){
        for (User user : allUsers){
            userId = user.getUserId();
            userIDs.add(userId);
            if (userIDs.contains(testUserId)) {
                usernameSuccess = true;
            } else {
                usernameSuccess = false;
            }
        }

        if(usernameSuccess == false) {
        System.out.println("That user does not exist!");
        }
        if(usernameSuccess == true){
            requestPassword();
            getTestPassword();
            comparePassword();
        }
    }

    public static void requestPassword(){
        System.out.println("What is your password?");
    }

    public static String getTestPassword(){
        Scanner scanId = new Scanner(System.in);
        testPassword= scanId.nextLine();
        return testPassword;
    }

    public static void comparePassword() {
        for (User user : allUsers) {
            password = user.getPassword();
            if (password.equals(testPassword)) {
                manageMainMenu menu = new manageMainMenu(user);
                menu.mainMenu();
            } else {
                System.out.println("Wrong password!");
            }
        }
    }
}

