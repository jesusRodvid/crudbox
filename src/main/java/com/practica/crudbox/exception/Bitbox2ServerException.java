package com.practica.crudbox.exception;

import org.springframework.http.HttpStatus;

public class Bitbox2ServerException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public Bitbox2ServerException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public Bitbox2ServerException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
