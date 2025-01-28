package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

@Service
public class GetRestockByIdService implements Query<Long, Restock> {

    private final RestockRepository restockRepository;

    public GetRestockByIdService(RestockRepository restockRepository) {
        this.restockRepository = restockRepository;
    }

    @Override
    public ResponseEntity<Restock> execute(Long restockId) {

        Optional<Restock> foundedRestock = restockRepository.findById(restockId);
        if (foundedRestock.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new Restock(foundedRestock.get()));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Restcock");
    }

}
