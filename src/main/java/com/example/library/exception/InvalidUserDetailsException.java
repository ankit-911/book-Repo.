package com.example.library.exception;

public class InvalidUserDetailsException extends RuntimeException {
    InvalidUserDetailsException(String str) {
        super(str);
    }
}
