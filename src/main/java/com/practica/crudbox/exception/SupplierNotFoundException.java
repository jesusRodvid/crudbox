package com.practica.crudbox.exception;

public class SupplierNotFoundException extends RuntimeException{

    public SupplierNotFoundException(Long id) {

        super("Couldn't find Supplier " + id);

    }

}
