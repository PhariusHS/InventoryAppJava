package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

public class UpdateRestockService implements Command<UpdateRestockCommand, Restock> {

    private final RestockRepository restockRepository;

    public UpdateRestockService(RestockRepository restockRepository) {
        this.restockRepository = restockRepository;
    }

    @Override
    public ResponseEntity<Restock> execute(UpdateRestockCommand command) {

        Optional<Restock> foundedRestock = restockRepository.findById(command.getId());

        if (foundedRestock.isPresent()) {
            Restock restock = command.getRestock(); // Get the new restock
            restock.setRestockId(command.getId()); // Set the restockId
            restockRepository.save(restock); // Save the new restock

            return ResponseEntity.status(HttpStatus.OK).body(new Restock(restock)); // Return the new restock
        }

        return null; // TODO error handling

    }

}
