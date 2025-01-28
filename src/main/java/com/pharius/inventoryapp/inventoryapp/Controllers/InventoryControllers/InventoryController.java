package com.pharius.inventoryapp.inventoryapp.Controllers.InventoryControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.UpdateInventoryCommand;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.CreateInventoryService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.DeleteInventoryService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetAllInventoriesService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetInventoryByIdService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.UpdateInventoryService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("inventory")
public class InventoryController {

    private final GetAllInventoriesService getAllInventoriesService;
    private final GetInventoryByIdService getInventoryByIdService;
    private final CreateInventoryService createInventoryService;
    private final UpdateInventoryService updateInventoryService;
    private final DeleteInventoryService deleteInventoryService;

    public InventoryController(GetAllInventoriesService getAllInventoriesService,
            GetInventoryByIdService getInventoryByIdService, CreateInventoryService createInventoryService,
             DeleteInventoryService deleteInventoryService,
             UpdateInventoryService updateInventoryService) {
        this.getAllInventoriesService = getAllInventoriesService;
        this.getInventoryByIdService = getInventoryByIdService;
        this.createInventoryService = createInventoryService;
        this.deleteInventoryService = deleteInventoryService;
        this.updateInventoryService = updateInventoryService;
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> GetAllInventories() {
        return getAllInventoriesService.execute(null);
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
        return getInventoryByIdService.execute(id);
    }

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory,
            @RequestParam Long establishmentId) {
        return createInventoryService.execute(inventory, establishmentId);
    }
    @PutMapping("/{inventoryId}")
    public ResponseEntity<Inventory> uptadeInventory(@PathVariable Long inventoryId, @RequestBody Inventory inventoryDetails) {    
        return updateInventoryService.execute(new UpdateInventoryCommand(inventoryId, inventoryDetails));
    }
    @DeleteMapping("/{inventoryId}")
    public ResponseEntity<Void> deleteInventory(@PathVariable Long inventoryId){
        return deleteInventoryService.execute(inventoryId);
    }

}
