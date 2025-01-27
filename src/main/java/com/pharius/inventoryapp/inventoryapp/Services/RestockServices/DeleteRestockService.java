package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

@Service
public class DeleteRestockService implements Command<Long, Void>  {

    private RestockRepository restockRepository;

    public DeleteRestockService(RestockRepository restockRepository) {
        this.restockRepository = restockRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long restockId) {
        
        Optional<Restock> foundedRestock = restockRepository.findById(restockId);

        if (foundedRestock.isPresent()) {
            
            restockRepository.deleteById(restockId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }

        return null; //TODO error handling

    }

}
