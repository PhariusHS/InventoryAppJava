package com.pharius.inventoryapp.inventoryapp.Models.RestockModels;

import java.time.LocalDateTime;

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
