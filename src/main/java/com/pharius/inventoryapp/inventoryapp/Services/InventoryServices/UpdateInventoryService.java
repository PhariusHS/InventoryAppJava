package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.UpdateInventoryCommand;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;

@Service
public class UpdateInventoryService implements Command<UpdateInventoryCommand, Inventory> {

    private final InventoryRepository inventoryRepository;

    public UpdateInventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<Inventory> execute(UpdateInventoryCommand updateInventoryCommand) {
        Optional<Inventory> foundedInventory = inventoryRepository.findById(updateInventoryCommand.getId());
        if (foundedInventory.isPresent()) {
            Inventory existingInventory = foundedInventory.get();
            existingInventory.setInventoryId(updateInventoryCommand.getId());
            Inventory updatedInventory = inventoryRepository.save(existingInventory);
            return ResponseEntity.status(HttpStatus.OK).body(new Inventory(updatedInventory));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Inventory"); 
    }

}
