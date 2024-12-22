package com.pharius.inventoryapp.inventoryapp.Controllers.TypeOfProductControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices.CreateTypeOfProductService;
import com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices.DeleteTypeOfProductService;
import com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices.GetAllTypesOfProductsService;
import com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices.GetTypeOfProductByIdService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/type")
public class TypeOfProductController {

    private final CreateTypeOfProductService createTypeOfProductService;
    private final GetAllTypesOfProductsService getAllTypesOfProductsService;
    private final GetTypeOfProductByIdService getTypeOfProductByIdService;
    private final DeleteTypeOfProductService deleteTypeOfProductService;

    public TypeOfProductController(CreateTypeOfProductService createTypeOfProductService,
            GetAllTypesOfProductsService getAllTypesOfProductsService,
            GetTypeOfProductByIdService getTypeOfProductByIdService,
            DeleteTypeOfProductService deleteTypeOfProductService) {
        this.createTypeOfProductService = createTypeOfProductService;
        this.getAllTypesOfProductsService = getAllTypesOfProductsService;
        this.getTypeOfProductByIdService = getTypeOfProductByIdService;
        this.deleteTypeOfProductService = deleteTypeOfProductService;
    }

    @GetMapping
    public ResponseEntity<List<TypeOfProduct>> getAllTypeOfProducts() {
        return getAllTypesOfProductsService.execute(null); // TODO: Add validation, error handling;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeOfProduct> getTypeOfProductById(@PathVariable Long id) {
        return getTypeOfProductByIdService.execute(id); // TODO: Add validation, error handling;
    }

    @PostMapping
    public ResponseEntity<TypeOfProduct> createTypeOfProduct(@RequestBody TypeOfProduct typeOfProduct) {
        return createTypeOfProductService.execute(typeOfProduct); // TODO: Add validation, error handling;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeOfProduct(@PathVariable Long id) {
        return deleteTypeOfProductService.execute(id); // TODO: Add validation, error handling;
    }

    //TODO: Add PUT mapping for updating a type of product

}
