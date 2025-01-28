package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryProductsRepository;

@Service
public class DeleteInventoryProductService implements Command<Long, Void> {

    private final InventoryProductsRepository inventoryProductsRepository;

    public DeleteInventoryProductService(InventoryProductsRepository inventoryProductsRepository) {
        this.inventoryProductsRepository = inventoryProductsRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long inventoryProductId) {
        Optional<InventoryProducts> foundedInventoryProduct = inventoryProductsRepository.findById(inventoryProductId);
        if (foundedInventoryProduct.isPresent()) {
            inventoryProductsRepository.deleteById(inventoryProductId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "InventoryProduct");
    }
}
