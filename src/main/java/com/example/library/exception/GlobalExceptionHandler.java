package com.example.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody()
    public ErrorResponse handleNotFoundException(BookNotFoundException ex) {
       return new com.example.library.exception.ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
