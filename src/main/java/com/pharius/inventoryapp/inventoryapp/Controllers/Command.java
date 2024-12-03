package com.pharius.inventoryapp.inventoryapp.Controllers;

import org.springframework.http.ResponseEntity;


public interface Command<I, O> {
    ResponseEntity<O> execute(I input);
}
