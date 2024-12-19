package com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;

public class DeleteEstablishmentService implements Command<Long, Void> {
    

    private final EstablishmentRepository establishmentRepository;

    public DeleteEstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long establishmentId) {
      
        establishmentRepository.deleteById(establishmentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 



    }

}
