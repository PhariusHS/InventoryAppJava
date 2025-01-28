package com.pharius.inventoryapp.inventoryapp.Models.ProductModels;

import lombok.Data;

@Data
public class UpdateProductCommand {
    private Long id;
    private Product product;

    public UpdateProductCommand(Long id, Product product) {
        this.id = id;
        this.product = product;
    }
}


