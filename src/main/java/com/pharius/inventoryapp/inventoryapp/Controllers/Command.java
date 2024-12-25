package com.pharius.inventoryapp.inventoryapp.Controllers;

import org.springframework.http.ResponseEntity;

public interface Command<Input, Output> {
    ResponseEntity<Output> execute(Input input);
}
