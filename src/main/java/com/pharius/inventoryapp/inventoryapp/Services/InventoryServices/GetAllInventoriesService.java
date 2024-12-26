package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;

@Service
public class GetAllInventoriesService implements Query<Void, List<Inventory>> {

    private final InventoryRepository inventoryRepository;

    public GetAllInventoriesService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<List<Inventory>> execute(Void input) {
        List<Inventory> inventories = inventoryRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(inventories);
    }

}
