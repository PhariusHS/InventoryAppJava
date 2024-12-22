package com.pharius.inventoryapp.inventoryapp.Services.ProductServices;

import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;


@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO > {
    


     
    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    
    @Override
    public ResponseEntity<ProductDTO> execute( UpdateProductCommand command){
        
        
        //Get the product by productId
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if(productOptional.isPresent()){
            Product product = command.getProduct(); 
            product.setProductId(command.getId()); 
            productRepository.save(product); // Save the new product

            return ResponseEntity.ok(new ProductDTO(product));
        }

       // .orElseThrow(() -> new RuntimeException("The product with the productId " + productId + " doesn't exist")); //Error handling not getting productId

        return null;
    }


}
