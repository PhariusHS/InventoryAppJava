package com.pharius.inventoryapp.inventoryapp.Models.RestockModels;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;

import lombok.Data;

@Data
public class RestockProductDTO {

private Long id;
private InventoryProducts inventoryProduct;
private int quantity;

public RestockProductDTO(RestockProduct restockProduct){
    this.id = restockProduct.getId();
    this.inventoryProduct = restockProduct.getInventoryProduct();
    this.quantity = restockProduct.getQuantity();
}


}
