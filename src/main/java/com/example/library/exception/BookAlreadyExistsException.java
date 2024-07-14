package com.example.library.exception;

public class BookAlreadyExistsException extends RuntimeException {
    BookAlreadyExistsException(String str) {
        super(str);
    }
}
