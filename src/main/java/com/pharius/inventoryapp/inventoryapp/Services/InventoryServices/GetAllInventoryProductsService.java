package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryProductsRepository;

@Service
public class GetAllInventoryProductsService implements Query<Void, List<InventoryProducts>> {

    private final InventoryProductsRepository inventoryProductsRepository;

    public GetAllInventoryProductsService(InventoryProductsRepository inventoryProductsRepository) {
        this.inventoryProductsRepository = inventoryProductsRepository;
    }

    @Override
    public ResponseEntity<List<InventoryProducts>> execute(Void inventoryProducts) {
        List<InventoryProducts> foundedInventoryProducts = inventoryProductsRepository.findAll();
        //
        return ResponseEntity.status(HttpStatus.OK).body(foundedInventoryProducts);

    }

}
