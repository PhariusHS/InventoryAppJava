package com.pharius.inventoryapp.inventoryapp.Models.ProductModels;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private TypeOfProduct typeOfProduct;
    private int quantity;


    
    public ProductDTO(Product product) {
        this.id = id;
        this.name = name;
        this.typeOfProduct = typeOfProduct;
        this.quantity = quantity;  
    }
}


