package com.example.library.exception;

public class InvalidBookDetailsException extends RuntimeException {
    InvalidBookDetailsException(String str) {
        super(str);
    }
}
