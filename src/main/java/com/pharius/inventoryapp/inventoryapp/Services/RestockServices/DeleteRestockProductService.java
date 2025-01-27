package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockProductRepository;

@Service
public class DeleteRestockProductService implements Command<Long, Void> {
    
    private final RestockProductRepository restockProductRepository;

    public DeleteRestockProductService(RestockProductRepository restockProductRepository){
        this.restockProductRepository = restockProductRepository;
    }


    @Override
    public ResponseEntity<Void> execute(Long restockProductId) {

        Optional<RestockProduct> foundedRestockProduct = restockProductRepository.findById((restockProductId));

        if (foundedRestockProduct.isPresent()){
            restockProductRepository.deleteById(restockProductId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return null; //TODO: Error handling and validation

    }
 
}


    