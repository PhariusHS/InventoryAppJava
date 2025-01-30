package com.pharius.inventoryapp.inventoryapp.Models.InventoryModels;

import java.util.Set;

import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;

import lombok.Data;

@Data
public class InventoryDTO {

private Long id;
private Establishment establishment;
private Set<InventoryProducts> inventoryProducts;

public InventoryDTO(Inventory inventory){
    this.id = inventory.getInventoryId();
    this.establishment = inventory.getEstablishment();
    this.inventoryProducts = inventory.getInventoryProducts();
}
}
