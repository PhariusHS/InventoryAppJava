package com.pharius.inventoryapp.inventoryapp.Services.ProductServices;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;

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


