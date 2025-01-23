package com.pharius.inventoryapp.inventoryapp.Controllers.InventoryProductsControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.CreateInventoryProductService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.DeleteInventoryProductService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetAllInventoryProductsService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.UpdateInventoryProductService;

@RestController
@RequestMapping("/inventory/product")
public class InventoryProductController {

    private final CreateInventoryProductService createInventoryProductService;
    private final DeleteInventoryProductService deleteInventoryProductService;
    private final UpdateInventoryProductService updateInventoryProductService;
    private final GetAllInventoryProductsService getAllInventoryProductsService;

    public InventoryProductController(CreateInventoryProductService createInventoryProductService,
            DeleteInventoryProductService deleteInventoryProductService,
            UpdateInventoryProductService updateInventoryProductService,
            GetAllInventoryProductsService getAllInventoryProductsService) {
        this.createInventoryProductService = createInventoryProductService;
        this.getAllInventoryProductsService = getAllInventoryProductsService;
        this.updateInventoryProductService = updateInventoryProductService;
        this.deleteInventoryProductService = deleteInventoryProductService;

    }

    @PostMapping
    public ResponseEntity<InventoryProducts> createInventoryProduct(@RequestBody InventoryProducts inventoryProducts,
            @RequestParam Long inventoryId, @RequestParam Long productId) {
        return createInventoryProductService.execute(inventoryProducts, inventoryId, productId);
    }

}
