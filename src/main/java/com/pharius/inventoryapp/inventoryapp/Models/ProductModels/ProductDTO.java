package com.pharius.inventoryapp.inventoryapp.Models.ProductModels;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private TypeOfProduct type;


    
    public ProductDTO(Product product) {
        this.id = id;
        this.name = name;
        this.type = type;
    }
}


