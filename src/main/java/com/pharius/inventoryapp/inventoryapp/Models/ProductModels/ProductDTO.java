package com.pharius.inventoryapp.inventoryapp.Models.ProductModels;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private TypeOfProduct typeOfProduct;
    private int quantity;


    
    public ProductDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.typeOfProduct = product.getTypeOfProduct();
        this.quantity = product.getQuantity();  
    }
}


