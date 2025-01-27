package com.pharius.inventoryapp.inventoryapp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    private final int status;
    private final String additionalInfo;

    public EntityNotFoundException(ErrorMessages errorMessages, String entity){
        super(entity + ErrorMessages.ENTITY_NOT_FOUND.getMessage());
        this.status = errorMessages.getStatus();
        this.additionalInfo = errorMessages.getAdditionalInfo();
    }
}
