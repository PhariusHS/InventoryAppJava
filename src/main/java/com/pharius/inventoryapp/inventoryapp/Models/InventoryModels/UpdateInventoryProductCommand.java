package com.pharius.inventoryapp.inventoryapp.Models.InventoryModels;

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
