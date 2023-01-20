package com.example.challengespringboottesting.exceptions;

public class InvalidBillIdException extends RuntimeException{
    public InvalidBillIdException(String message) {
    super(message);
}

}
