package com.example.pruebaNTTDATA.exceptions;

import org.springframework.http.HttpStatus;

public class RecordAlreadyExits extends RuntimeException{
    private  String message;
    private HttpStatus httpStatus;
    public RecordAlreadyExits(String message, HttpStatus httpStatus ) {
        super(message);
        this.message= message;
    }

    public RecordAlreadyExits(String message) {
    }
}
