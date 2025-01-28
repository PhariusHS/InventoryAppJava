package com.pharius.inventoryapp.inventoryapp.Models.InventoryModels;

import lombok.Data;

@Data
public class UpdateInventoryCommand {
    
    private Long id;
    private Inventory inventory;

    public UpdateInventoryCommand(Long id, Inventory inventory){
        this.id = id;
        this.inventory = inventory;
    }

}
