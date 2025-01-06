package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.DoubleRelationalCommand;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryProductsRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;

@Service
public class CreateInventoryProductService implements DoubleRelationalCommand<InventoryProducts, InventoryProducts, Long, Long > {
    
    private final InventoryProductsRepository inventoryProductsRepository;
    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;


    public CreateInventoryProductService(InventoryProductsRepository inventoryProductsRepository, InventoryRepository inventoryRepository, ProductRepository productRepository) {
        this.inventoryProductsRepository = inventoryProductsRepository;
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<InventoryProducts> execute(InventoryProducts inventoryProducts, Long inventoryId, Long productId) {
      
        Optional<Inventory> foundedInventory = inventoryRepository.findById(inventoryId);
        Optional<Product> foundedProduct = productRepository.findById(productId);

        if(foundedInventory.isPresent() && foundedProduct.isPresent()){

            inventoryProducts.setInventory(foundedInventory.get());
            inventoryProducts.setProduct(foundedProduct.get());
            InventoryProducts savedInventoryProducts = inventoryProductsRepository.save(inventoryProducts);
            return ResponseEntity.status(HttpStatus.OK).body(savedInventoryProducts);

        }

        return null;

    }   

}
