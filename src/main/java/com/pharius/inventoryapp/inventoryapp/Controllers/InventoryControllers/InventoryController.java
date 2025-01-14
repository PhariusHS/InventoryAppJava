package com.pharius.inventoryapp.inventoryapp.Controllers.InventoryControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.CreateInventoryService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetAllInventoriesService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetInventoryByIdService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    private final GetAllInventoriesService getAllInventoriesService;
    private final GetInventoryByIdService getInventoryByIdService;
    private final CreateInventoryService createInventoryService;

    public InventoryController(GetAllInventoriesService getAllInventoriesService,
            GetInventoryByIdService getInventoryByIdService, CreateInventoryService createInventoryService) {
        this.getAllInventoriesService = getAllInventoriesService;
        this.getInventoryByIdService = getInventoryByIdService;
        this.createInventoryService = createInventoryService;
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> GetAllInventories() {
        return getAllInventoriesService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        return getInventoryByIdService.execute(id);
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory,
            @RequestParam Long establishmentId) {
        return createInventoryService.execute(inventory, establishmentId);
    }

}
