package com.pharius.inventoryapp.inventoryapp.Models.RestockModels;

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
