package com.example.library.exception;

public class UserNotAuthorizedException extends RuntimeException{
    UserNotAuthorizedException(String str)
    {
        super(str);
    }
}
