package com.spibook.core.dao.exceptions;

public class NoSuchMessageException extends Exception {
    public NoSuchMessageException(String text){
        super(text);
    }
}
