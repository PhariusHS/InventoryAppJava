package com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels;

import lombok.Data;

@Data
public class EstablishmentDTO {
    
    private Long establishmentId;
    private String name;
    private String location;



    public EstablishmentDTO(Establishment establishment) {
        
        this.establishmentId = establishmentId;
        this.name = name;
        this.location = location;

    }


}