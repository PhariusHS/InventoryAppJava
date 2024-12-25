package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;

public class GetInventoryByIdService implements Query<Long, Inventory> {

    private final InventoryRepository inventoryRepository;

    public GetInventoryByIdService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<Inventory> execute(Long id) {

        Optional<Inventory> foundedInventory = inventoryRepository.findById(id);

        if (foundedInventory.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(foundedInventory.get());
        }

        return null;

    }

}
