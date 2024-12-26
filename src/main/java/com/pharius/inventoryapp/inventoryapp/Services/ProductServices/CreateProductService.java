package com.pharius.inventoryapp.inventoryapp.Services.ProductServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.DoubleRelationalCommand;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class CreateProductService implements DoubleRelationalCommand<Product, ProductDTO, Long, Long> {

    private final ProductRepository productRepository;
    private final TypeOfProductRepository typeOfProductRepository;
    private final InventoryRepository inventoryRepository;

    public CreateProductService(ProductRepository productRepository, TypeOfProductRepository typeOfProductRepository,
            InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.typeOfProductRepository = typeOfProductRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product, Long typeOfProductId, Long inventoryId) {

        if (typeOfProductId == null || inventoryId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        product.setTypeOfProduct(typeOfProductRepository.findById(typeOfProductId).get());
        product.setInventory(inventoryRepository.findById(inventoryId).get());
        Product savedProduct = productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));

    }

}
