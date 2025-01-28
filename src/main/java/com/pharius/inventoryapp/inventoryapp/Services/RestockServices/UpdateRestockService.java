package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.UpdateRestockCommand;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

@Service
public class UpdateRestockService implements Command<UpdateRestockCommand, Restock> {

    private final RestockRepository restockRepository;

    public UpdateRestockService(RestockRepository restockRepository) {
        this.restockRepository = restockRepository;
    }
    @Override
    public ResponseEntity<Restock> execute(UpdateRestockCommand command) {

        Optional<Restock> foundedRestock = restockRepository.findById(command.getId());
        if (foundedRestock.isPresent()) {
            Restock existingRestock = foundedRestock.get(); // Get the new restock
            LocalDateTime localDateTime = LocalDateTime.now(); // Get the date of modification
            existingRestock.setRestockId(command.getId()); // Set the restockId
            existingRestock.setLocalDateTime(localDateTime);// Set the modification date
            Restock updatedRestock = restockRepository.save(existingRestock); // Save the new restock
            return ResponseEntity.status(HttpStatus.OK).body(new Restock(updatedRestock)); // Return the new restock
        }
         throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Restock");
    }

}
