package com.pharius.inventoryapp.inventoryapp.Exceptions;

import java.text.Format;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(exception.getMessage(), exception.getStatus(), exception.getAdditionalInfo()));
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEntityNotValidConstraints(ConstraintViolationException exception){
        return new ErrorResponse(exception.getConstraintViolations().iterator().next().getMessageTemplate()
        , 400
        , String.format(
            "Field '%s' with value '%s' caused the validation error.",
            exception.getConstraintViolations().iterator().next().getPropertyPath().toString(), // Nombre del campo
            exception.getConstraintViolations().iterator().next().getInvalidValue()             // Valor rechazado
        ));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error: " + exception.getMessage());
    }
}


