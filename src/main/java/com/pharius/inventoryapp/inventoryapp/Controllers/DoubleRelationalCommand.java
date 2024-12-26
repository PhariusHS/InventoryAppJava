package com.pharius.inventoryapp.inventoryapp.Controllers;

import org.springframework.http.ResponseEntity;

public interface DoubleRelationalCommand<Input, Output, RelationalInput, SecondRelationalInput> {
    ResponseEntity<Output> execute(Input input, RelationalInput relationalInput, SecondRelationalInput secondRelationalInput);
}
