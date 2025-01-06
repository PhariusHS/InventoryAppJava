package com.pharius.inventoryapp.inventoryapp.Controllers.InventoryControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.CreateInventoryProductService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.CreateInventoryService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetAllInventoriesService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetAllInventoryProductsService;
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

    private final GetAllInventoryProductsService getAllInventoryProductsService;
    private final CreateInventoryProductService createInventoryProductService;

    public InventoryController(GetAllInventoriesService getAllInventoriesService,
            GetInventoryByIdService getInventoryByIdService, CreateInventoryService createInventoryService, CreateInventoryProductService createInventoryProductService, GetAllInventoryProductsService getAllInventoryProductsService) {
        this.getAllInventoriesService = getAllInventoriesService;
        this.getInventoryByIdService = getInventoryByIdService;
        this.createInventoryService = createInventoryService;
        this.createInventoryProductService = createInventoryProductService;
        this.getAllInventoryProductsService = getAllInventoryProductsService;
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
    public ResponseEntity<Inventory> createInventory (@RequestBody Inventory inventory, @RequestParam Long establishmentId) {
        return createInventoryService.execute(inventory, establishmentId);
    }
    


    @GetMapping("/product")
    public ResponseEntity<List<InventoryProducts>> getAllInventoryProducts() {
        return getAllInventoryProductsService.execute(null);
    }
    

    @PostMapping("/product")
    public ResponseEntity<InventoryProducts> createInventoryProduct (@RequestBody InventoryProducts inventoryProducts, @RequestParam Long inventoryId, @RequestParam Long productId) {
        return createInventoryProductService.execute(inventoryProducts, inventoryId, productId);
    }

    

}
