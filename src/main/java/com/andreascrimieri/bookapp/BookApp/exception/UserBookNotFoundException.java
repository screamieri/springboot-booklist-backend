package com.andreascrimieri.bookapp.BookApp.exception;

public class UserBookNotFoundException extends RuntimeException{

    public UserBookNotFoundException(String message) {
        super(message);
    }
}
