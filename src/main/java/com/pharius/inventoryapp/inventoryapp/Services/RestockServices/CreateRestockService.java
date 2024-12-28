package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.RelationalCommand;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

@Service
public class CreateRestockService implements RelationalCommand<Restock, Restock, Long> {

    private final RestockRepository restockRepository;
    private final EstablishmentRepository establishmentRepository;

    public CreateRestockService(RestockRepository restockRepository, EstablishmentRepository establishmentRepository) {
        this.restockRepository = restockRepository;
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public ResponseEntity<Restock> execute(Restock restock, Long establishmentId) {

        Optional<Establishment> foundedEstablishment = establishmentRepository.findById(establishmentId);
        if (!foundedEstablishment.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        restock.setEstablishment(foundedEstablishment.get());
        restock.setLocalDateTime(LocalDateTime.now());

        Restock createdRestock = restockRepository.save(restock);

        return ResponseEntity.status(HttpStatus.CREATED).body(new Restock(createdRestock));
    }

}
