package com.pharius.inventoryapp.inventoryapp.Models.InventoryModels;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;

import lombok.Data;

@Data
public class InventoryProductsDTO {
    
private Long id;
private Product product;
private int quantity;

public InventoryProductsDTO(InventoryProducts inventoryProducts){
    this.id = inventoryProducts.getId();
    this.product = inventoryProducts.getProduct();
    this.quantity = inventoryProducts.getQuantity();
}    


}
