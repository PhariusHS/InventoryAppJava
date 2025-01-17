package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;

import lombok.Data;

@Data
public class UpdateRestockProductCommand {

    private Long id;
    private RestockProduct restockProduct;

    public UpdateRestockProductCommand(Long id, RestockProduct restockProduct) {
        this.id = id;
        this.restockProduct = restockProduct;
    }
}
