package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryProductsRepository;

@Service
public class DeleteInventoryProductService implements Command<Long, InventoryProducts> {

    private final InventoryProductsRepository inventoryProductsRepository;

    public DeleteInventoryProductService(InventoryProductsRepository inventoryProductsRepository) {
        this.inventoryProductsRepository = inventoryProductsRepository;
    }

    @Override
    public ResponseEntity<InventoryProducts> execute(Long inventoryProductId) {
        Optional<InventoryProducts> foundedInventoryProduct = inventoryProductsRepository.findById(inventoryProductId);
        if (foundedInventoryProduct.isPresent()) {
            inventoryProductsRepository.deleteById(inventoryProductId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null; //TODO error handling and validation
    }
}
