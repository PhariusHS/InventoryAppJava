package com.pharius.inventoryapp.inventoryapp.Exceptions;

import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String message;
    private final int status;
    private final String additionalInfo; 

    public ErrorResponse(String message, int status, String additionalInfo) {
        this.message = message;
        this.status = status;
        this.additionalInfo = additionalInfo;
    }

    public ErrorResponse(String message, int status) {
        this(message, status, null); // Constructor withoud added info
    }
}