package com.twu.objects;
import com.twu.methods.manageBookReservations;
import com.twu.methods.manageMainMenu;

public class bookReservation {
    private Book book;
    private User user;

    public bookReservation(Book book, User user){
        this.book = book;
        this.user = user;
        manageBookReservations.addReservationToList(this);
        manageMainMenu.addBookReservationToList(this);
    }

    public Book getBook() { return book;}

    public User getUser() {
        return user;
    }
}