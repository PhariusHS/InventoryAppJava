package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProductDTO;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.UpdateRestockProductCommand;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockProductRepository;

@Service
public class UpdateRestockProductService implements Command<UpdateRestockProductCommand, RestockProductDTO> {
    
   private final RestockProductRepository restockProductRepository;

    public UpdateRestockProductService(RestockProductRepository restockProductRepository){
        this.restockProductRepository = restockProductRepository;
    }

    @Override
    public ResponseEntity<RestockProductDTO> execute(UpdateRestockProductCommand updateRestockProductCommand) {
       
        Optional<RestockProduct> foundedRestockProduct = restockProductRepository.findById(updateRestockProductCommand.getId());

        if (foundedRestockProduct.isPresent()){
            RestockProduct existingRestockProduct = foundedRestockProduct.get();
            existingRestockProduct.setId(updateRestockProductCommand.getId());
            RestockProduct updatedRestockProduct = restockProductRepository.save(existingRestockProduct);
            return ResponseEntity.status(HttpStatus.OK).body(new RestockProductDTO(updatedRestockProduct));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "RestockProduct");
    }

}
