package com.example.library.exception;

public class BookServiceException extends RuntimeException {
    BookServiceException(String str) {
        super(str);
    }
}
