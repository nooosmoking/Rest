package com.example.Rest.exceptions;

import java.util.NoSuchElementException;

public class NoSuchAccountException extends NoSuchElementException {
    public NoSuchAccountException(String msg){
        super(msg);
    }
}
