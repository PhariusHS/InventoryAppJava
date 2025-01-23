package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;

import lombok.Data;

@Data
public class UpdateInventoryProductCommand {

    private Long id;
    private InventoryProducts inventoryProducts;

    public UpdateInventoryProductCommand(Long id, InventoryProducts inventoryProducts) {
        this.id = id;
        this.inventoryProducts = inventoryProducts;
    }
}
