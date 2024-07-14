package com.example.library.exception;

public class ErrorResponse {
    private Integer status;
    private String message;

    public ErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
