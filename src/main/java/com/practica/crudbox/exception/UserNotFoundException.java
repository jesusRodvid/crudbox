package com.practica.crudbox.exception;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(String username) {

    super("Couldn't find user " + username);

    }
}
