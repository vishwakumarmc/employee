package com.pack.employee.exception.handler;

public class ErrorDetails {

    private String message;
    private String details;
    private int status;

    public ErrorDetails(String message, String details, int status) {
        this.message = message;
        this.details = details;
        this.status = status;
    }
}
