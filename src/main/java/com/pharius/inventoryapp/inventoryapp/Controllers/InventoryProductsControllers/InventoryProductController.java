package com.pharius.inventoryapp.inventoryapp.Controllers.InventoryProductsControllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.CreateInventoryProductService;
import com.pharius.inventoryapp.inventoryapp.Services.InventoryServices.GetAllInventoryProductsService;


@RestController
@RequestMapping("/inventory/product")
public class InventoryProductController  {
    

    private final GetAllInventoryProductsService getAllInventoryProductsService;
    private final CreateInventoryProductService createInventoryProductService;

    public InventoryProductController( GetAllInventoryProductsService getAllInventoryProductsService, CreateInventoryProductService createInventoryProductService) {
        this.getAllInventoryProductsService = getAllInventoryProductsService;
        this.createInventoryProductService = createInventoryProductService;
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
