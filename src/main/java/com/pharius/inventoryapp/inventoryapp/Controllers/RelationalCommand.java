package com.pharius.inventoryapp.inventoryapp.Controllers;

import org.springframework.http.ResponseEntity;

public interface RelationalCommand<Input, Output, RelationalInput> {
    ResponseEntity<Output> execute(Input input, RelationalInput relationalInput);
}
