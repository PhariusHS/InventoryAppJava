package com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class GetTypeOfProductByIdService implements Query<Long, TypeOfProduct> {

    private final TypeOfProductRepository typeOfProductRepository;

    public GetTypeOfProductByIdService(TypeOfProductRepository typeOfProductRepository) {
        this.typeOfProductRepository = typeOfProductRepository;
    }

    @Override
    public ResponseEntity<TypeOfProduct> execute(Long id) {
        Optional<TypeOfProduct> foundedType = typeOfProductRepository.findById(id);
        if (foundedType.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(foundedType.get());
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Type Of Product");
    }

}