package com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.EstablishmentDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;

@Service
public class GetEstablishmentByIdService implements Query<Long, EstablishmentDTO> {


    private final EstablishmentRepository establishmentRepository;

    public GetEstablishmentByIdService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public ResponseEntity<EstablishmentDTO> execute(Long establishmentId) {

       Optional<Establishment> foundedEstablishment = establishmentRepository.findById(establishmentId);

       if(foundedEstablishment.isPresent()) {
          return ResponseEntity.status(HttpStatus.OK).body(new EstablishmentDTO(foundedEstablishment.get()));
       }

       //TODO: Error handling, not getting establishment with the establishmentId
       return null;
    }

    


    
}
