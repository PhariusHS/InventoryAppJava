package com.pharius.inventoryapp.inventoryapp.Controllers.ProductControllers;

import org.springframework.http.ResponseEntity;

public interface Query<I, O> {
    ResponseEntity<O> execute(I input);
}
