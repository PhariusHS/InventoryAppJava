package com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class UpdateTypeOfProductService implements Command<UpdateTypeOfProductCommand, TypeOfProduct> {
    
    private final TypeOfProductRepository typeOfProductRepository;

    public UpdateTypeOfProductService(TypeOfProductRepository typeOfProductRepository){
        this.typeOfProductRepository = typeOfProductRepository;
    }
    @Override
    public ResponseEntity<TypeOfProduct> execute(UpdateTypeOfProductCommand typeOfProductCommand) {
        Optional<TypeOfProduct> foundedTypeOfProduct = typeOfProductRepository.findById(typeOfProductCommand.getId());
        if(foundedTypeOfProduct.isPresent()){
            TypeOfProduct existingTypeOfProduct = foundedTypeOfProduct.get();
            existingTypeOfProduct.setTypeOfProductId(typeOfProductCommand.getId());
            TypeOfProduct updatedTypeOfProduct = typeOfProductRepository.save(existingTypeOfProduct);
            return ResponseEntity.status(HttpStatus.OK).body(new TypeOfProduct(updatedTypeOfProduct));
        }
        return null; //TODO: Handling errors and validation
    }

}
