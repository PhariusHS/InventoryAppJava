package com.pharius.inventoryapp.inventoryapp.Controllers.TypeOfProductControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices.CreateTypeOfProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/type")
public class TypeOfProductController {
    

    private final CreateTypeOfProductService createTypeOfProductService;

    public TypeOfProductController(CreateTypeOfProductService createTypeOfProductService) {
        this.createTypeOfProductService = createTypeOfProductService;
    }


    @PostMapping
    public ResponseEntity<TypeOfProduct> createTypeOfProduct(@RequestBody TypeOfProduct typeOfProduct) {
        return createTypeOfProductService.execute(typeOfProduct); //TODO: Add validation, error handling and response entity its throwing null on postman (Error on DTO object);
    }
    


}
