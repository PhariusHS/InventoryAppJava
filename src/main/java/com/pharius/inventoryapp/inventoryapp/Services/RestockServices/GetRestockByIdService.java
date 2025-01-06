package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

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

        return null; // TODO error handling
    }

}
