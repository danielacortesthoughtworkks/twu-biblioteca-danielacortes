package com.twu.objects;
import com.twu.methods.manageLogin;

public class User {
    private String userid;
    private String name;
    private String password;
    private String email;
    private int phonenumber;

    public User(String userid, String name, String password, String email, int phonenumber) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phonenumber = phonenumber;
        manageLogin.addUserToList(this);
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public Integer getPhone(){
        return phonenumber;
    }
    public String getUserId(){
        return userid;
    }
}
