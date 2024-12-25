package com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class CreateTypeOfProductService implements Command<TypeOfProduct, TypeOfProduct> {

    private final TypeOfProductRepository typeOfProductRepository;

    public CreateTypeOfProductService(TypeOfProductRepository typeOfProductRepository) {
        this.typeOfProductRepository = typeOfProductRepository;
    }

    @Override
    public ResponseEntity<TypeOfProduct> execute(TypeOfProduct typeOfProduct) {

        TypeOfProduct savedType = typeOfProductRepository.save(typeOfProduct); // Save the new typeOfProduct

        return ResponseEntity.status(HttpStatus.CREATED).body(new TypeOfProduct(savedType));

    }

}
