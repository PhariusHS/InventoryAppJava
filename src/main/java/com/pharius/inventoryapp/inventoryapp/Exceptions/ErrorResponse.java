package com.pharius.inventoryapp.inventoryapp.Exceptions;

import jakarta.annotation.Nullable;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final String message;
    @Nullable
    private final Integer status;
    @Nullable
    private final String additionalInfo; 

    public ErrorResponse(String message, Integer status, String additionalInfo) {
        this.message = message;
        this.status = status;
        this.additionalInfo = additionalInfo;
    }

    public ErrorResponse(String message, Integer status) {
        this(message, status, null); // Constructor withoud added info
    }

    public ErrorResponse(String message) {
        this(message, null, null);// Constructor withoud added info
    }

  

}