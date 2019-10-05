package com.spibook.core.dao.exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
