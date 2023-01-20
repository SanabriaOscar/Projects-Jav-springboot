package com.example.challengespringboottesting.exceptions;

public class InvalidTargetFundsException extends RuntimeException{
    public InvalidTargetFundsException(String message) {
        super(message);
    }
}
