package com.pharius.inventoryapp.inventoryapp.Models.RestockModels;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;

import lombok.Data;

@Data
public class RestockProductDTO {

private Long id;
private Product product;
private int quantity;

public RestockProductDTO(RestockProduct restockProduct){
    this.id = restockProduct.getId();
    this.product = restockProduct.getProduct();
    this.quantity = restockProduct.getQuantity();
}


}
