package com.pharius.inventoryapp.inventoryapp.Models.RestockModels;

import java.time.LocalDateTime;
import java.util.Set;

import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;

import lombok.Data;

@Data
public class RestockDTO {

    private Long id;
    private Establishment establishment;
    private LocalDateTime localDateTime;
    private Set<RestockProduct> restockProducts;

    public RestockDTO(Restock restock){
        this.id = restock.getRestockId();
        this.establishment  = restock.getEstablishment();
        this.localDateTime = restock.getLocalDateTime();
        this.restockProducts = restock.getRestockProducts();
    }

}
