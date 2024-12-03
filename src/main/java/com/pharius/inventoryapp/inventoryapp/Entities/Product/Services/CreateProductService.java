package com.pharius.inventoryapp.inventoryapp.Entities.Product.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Model.Product;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Model.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;


@Service
public class CreateProductService implements Command<Product, ProductDTO>{

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {

        Product savedProduct = productRepository.save(product); 
        
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));

    }

}
