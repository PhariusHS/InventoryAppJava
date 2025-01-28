package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;

@Service
public class DeleteInventoryService implements Command<Long, Void>

{
    private final InventoryRepository inventoryRepository;

    public DeleteInventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long inventoryId) {

        Optional<Inventory> foundedInventory = inventoryRepository.findById(inventoryId);
        if (foundedInventory.isPresent()) {
            inventoryRepository.deleteById(inventoryId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Inventory");
    }

}
