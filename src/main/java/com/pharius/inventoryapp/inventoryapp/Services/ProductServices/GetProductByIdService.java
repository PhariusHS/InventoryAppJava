package com.pharius.inventoryapp.inventoryapp.Services.ProductServices;

import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.ProductControllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;


@Service
public class GetProductByIdService implements Query<Long , ProductDTO>{


    private final ProductRepository productRepository;

    public GetProductByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    

    @Override
    public ResponseEntity<ProductDTO> execute(Long productId) {

                
               Optional<Product> foundedProduct = productRepository.findById(productId);
                if (foundedProduct.isPresent()){
                    return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(foundedProduct.get()));
                    

                }
                //.orElseThrow( () -> new RuntimeException("The product with the productId " + productId + " doesn't exist")); //Error handling, not getting product with the productId
                return null;
        
    }

}
