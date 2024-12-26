package com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class DeleteTypeOfProductService implements Command<Long, Void> {

    private final TypeOfProductRepository typeOfProductRepository;

    public DeleteTypeOfProductService(TypeOfProductRepository typeOfProductRepository) {
        this.typeOfProductRepository = typeOfProductRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long id) {
        typeOfProductRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
