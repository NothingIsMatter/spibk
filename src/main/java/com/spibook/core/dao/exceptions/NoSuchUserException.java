package com.spibook.core.dao.exceptions;

public class NoSuchUserException extends Exception {
    public NoSuchUserException(String message){
        super(message);
    }
}
