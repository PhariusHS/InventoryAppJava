package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockProductRepository;

@Service
public class UpdateRestockProductService implements Command<UpdateRestockProductCommand, RestockProduct> {
    
   private final RestockProductRepository restockProductRepository;

    public UpdateRestockProductService(RestockProductRepository restockProductRepository){
        this.restockProductRepository = restockProductRepository;
    }

    @Override
    public ResponseEntity<RestockProduct> execute(UpdateRestockProductCommand updateRestockProductCommand) {
       
        Optional<RestockProduct> foundedRestockProduct = restockProductRepository.findById(updateRestockProductCommand.getId());

        if (foundedRestockProduct.isPresent()){
            RestockProduct existingRestockProduct = foundedRestockProduct.get();
            existingRestockProduct.setId(updateRestockProductCommand.getId());
            RestockProduct updatedRestockProduct = restockProductRepository.save(existingRestockProduct);
            return ResponseEntity.status(HttpStatus.OK).body(new RestockProduct(updatedRestockProduct));
        }
        return null; // TODO: error handling and validation
    }

}
