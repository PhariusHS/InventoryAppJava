package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.time.LocalDateTime;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;

import lombok.Data;

@Data
public class UpdateRestockCommand {

    public Long id;
    public Restock restock;
    public LocalDateTime localDateTime;

    public UpdateRestockCommand(Long id, Restock restock) {
        this.id = id;
        this.restock = restock;
    }

}
