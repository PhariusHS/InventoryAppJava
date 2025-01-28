package com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;

@Service
public class GetAllEstablishmentsService implements Query<Void, List<Establishment>> {


    private final EstablishmentRepository establishmentRepository;

    public GetAllEstablishmentsService (EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }


    @Override
    public ResponseEntity<List<Establishment>> execute(Void input) {
            List<Establishment> establishments = establishmentRepository.findAll();
            //If there's not establishments just returns an empty list
            return ResponseEntity.status(HttpStatus.OK).body(establishments);
    }
    
}
