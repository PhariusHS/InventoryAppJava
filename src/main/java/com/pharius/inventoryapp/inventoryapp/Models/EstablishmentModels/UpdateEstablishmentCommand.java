package com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels;

import lombok.Data;

@Data
public class UpdateEstablishmentCommand {
    private Long id;
    private Establishment establishment;

    public UpdateEstablishmentCommand(Long id, Establishment establishment) {
        this.establishment = establishment;
        this.id = id;
    }
}
