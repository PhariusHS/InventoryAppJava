package com.pharius.inventoryapp.inventoryapp.Entities.Product.Services;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Model.Product;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;


@Service
public class DeleteProductService implements Command<Long, Void> {

   


    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

      
    public ResponseEntity<Void> execute(Long productId){

        //Get the product to delete by productId
        
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()){
            productRepository.deleteById(productId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }


        return null;

       // .orElseThrow(() -> new RuntimeException("The product with the productId " + productId + "doesn't exist")); //Error handling not getting productId

        //delete the product
      

    }

}
