package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;

@Service
public class GetInventoryByIdService implements Query<Long, InventoryDTO> {

    private final InventoryRepository inventoryRepository;

    public GetInventoryByIdService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<InventoryDTO> execute(Long id) {
        Optional<Inventory> foundedInventory = inventoryRepository.findById(id);
        if (foundedInventory.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new InventoryDTO(foundedInventory.get()));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Inventory");
    }

}
