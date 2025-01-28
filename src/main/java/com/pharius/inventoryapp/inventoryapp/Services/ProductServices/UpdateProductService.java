package com.pharius.inventoryapp.inventoryapp.Services.ProductServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.UpdateProductCommand;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;
    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand updateProductCommand) {
        // Get the product by productId
        Optional<Product> foundedProduct = productRepository.findById(updateProductCommand.getId());
        if (foundedProduct.isPresent()) {
            Product existingProduct = updateProductCommand.getProduct(); // Get the new product
            existingProduct.setProductId(updateProductCommand.getId());
            Product updatedProduct = productRepository.save(existingProduct); // Save the new product
            return ResponseEntity.status(HttpStatus.OK).body(new ProductDTO(updatedProduct));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Product");
    }

}
