package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProductsDTO;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.UpdateInventoryProductCommand;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryProductsRepository;

@Service
public class UpdateInventoryProductService implements Command<UpdateInventoryProductCommand, InventoryProductsDTO> {
    
    private final InventoryProductsRepository inventoryProductsRepository;

    public UpdateInventoryProductService(InventoryProductsRepository inventoryProductsRepository){
        this.inventoryProductsRepository = inventoryProductsRepository;
    }

    @Override
    public ResponseEntity<InventoryProductsDTO> execute(UpdateInventoryProductCommand updateInventoryProductCommand) {
        
        Optional<InventoryProducts> foundedInventoryProducts = inventoryProductsRepository.findById(updateInventoryProductCommand.getId());
        if(foundedInventoryProducts.isPresent()){
            InventoryProducts existingInventoryProducts = foundedInventoryProducts.get();
            existingInventoryProducts.setId(updateInventoryProductCommand.getId());
            InventoryProducts updatedInventoryProducts = inventoryProductsRepository.save(existingInventoryProducts);
            return ResponseEntity.status(HttpStatus.OK).body(new InventoryProductsDTO(updatedInventoryProducts));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "InventoryProduct");
    }
}
