package com.example.library.exception;

public class UserAlreadyExistsException extends RuntimeException{
    UserAlreadyExistsException(String str)
    {
        super(str);
    }
}
