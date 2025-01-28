package com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class DeleteTypeOfProductService implements Command<Long, Void> {

    private final TypeOfProductRepository typeOfProductRepository;

    public DeleteTypeOfProductService(TypeOfProductRepository typeOfProductRepository) {
        this.typeOfProductRepository = typeOfProductRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long typeOfProductId) {
        Optional<TypeOfProduct> foundedTypeOfProduct = typeOfProductRepository.findById(typeOfProductId);
        if (foundedTypeOfProduct.isPresent()) {
            typeOfProductRepository.deleteById(typeOfProductId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Type Of Product");
    }

}
