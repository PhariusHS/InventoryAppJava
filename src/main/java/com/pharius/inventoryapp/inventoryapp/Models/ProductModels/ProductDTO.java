package com.pharius.inventoryapp.inventoryapp.Models.ProductModels;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;


    
    public ProductDTO(Product product) {
        this.id = id;
        this.name = name;
    }
}


