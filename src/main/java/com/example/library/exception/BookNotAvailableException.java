package com.example.library.exception;

public class BookNotAvailableException extends RuntimeException {
    BookNotAvailableException(String str) {
        super(str);
    }
}
