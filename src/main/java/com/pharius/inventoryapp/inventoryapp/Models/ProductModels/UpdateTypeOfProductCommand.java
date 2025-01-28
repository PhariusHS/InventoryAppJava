package com.pharius.inventoryapp.inventoryapp.Models.ProductModels;

import lombok.Data;

@Data
public class UpdateTypeOfProductCommand {
    private Long id;
    private TypeOfProduct typeOfProduct;

    public UpdateTypeOfProductCommand(Long id, TypeOfProduct typeOfProduct){
        this.id = id;
        this.typeOfProduct = typeOfProduct;
    }
}
