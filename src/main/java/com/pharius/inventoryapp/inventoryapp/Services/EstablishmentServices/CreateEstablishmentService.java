package com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.EstablishmentDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;


@Service
public class CreateEstablishmentService implements Command<Establishment, EstablishmentDTO>  {


    private final EstablishmentRepository establishmentRepository;

    public CreateEstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public ResponseEntity<EstablishmentDTO> execute(Establishment establishment) {

        Establishment savedEstablishment = establishmentRepository.save(establishment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new EstablishmentDTO(savedEstablishment));
    }
    
}
