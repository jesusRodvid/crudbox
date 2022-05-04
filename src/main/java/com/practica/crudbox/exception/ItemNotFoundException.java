package com.practica.crudbox.exception;

public class ItemNotFoundException extends  RuntimeException{

    public ItemNotFoundException(Long id) {

    super("Couldn't find item " + id);

    }
}
