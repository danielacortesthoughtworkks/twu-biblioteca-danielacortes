package com.twu.model;
import com.twu.infrastructure.ManageBookReservations;
import com.twu.infrastructure.ManageMainMenu;

public class BookReservation {
    private Book book;
    private User user;

    public BookReservation(Book book, User user){
        this.book = book;
        this.user = user;
        ManageBookReservations.addReservationToList(this);
        ManageMainMenu.addBookReservationToList(this);
    }

    public Book getBook() { return book;}

    public User getUser() {
        return user;
    }
}