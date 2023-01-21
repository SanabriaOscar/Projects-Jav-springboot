package com.example.pruebaNTTDATA.exceptions;


import org.springframework.http.HttpStatus;

public class DataNotFoundException extends RuntimeException {
    private  String message;
    private HttpStatus httpStatus;
    public DataNotFoundException(String message, HttpStatus httpStatus ) {
    super(message);
    this.message= message;
    }

    public DataNotFoundException(String message) {
    }
}
