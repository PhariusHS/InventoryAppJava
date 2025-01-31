package com.pharius.inventoryapp.inventoryapp.Models.InventoryModels;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;

import lombok.Data;

@Data
public class InventoryProductsDTO {
    

private Product product;
private int stock;

public InventoryProductsDTO(InventoryProducts inventoryProducts){
    this.product = inventoryProducts.getProduct();
    this.stock = inventoryProducts.getStock();
}    

}
