package com.pack.employee.exception.handler;

import com.fasterxml.jackson.annotation.JsonAnyGetter;


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
