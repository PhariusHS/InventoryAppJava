package com.pharius.inventoryapp.inventoryapp.Services.ProductServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.RelationalCommand;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class CreateProductService implements RelationalCommand<Product, ProductDTO, Long> {

    private final ProductRepository productRepository;
    private final TypeOfProductRepository typeOfProductRepository;

    public CreateProductService(ProductRepository productRepository, TypeOfProductRepository typeOfProductRepository) {
        this.productRepository = productRepository;
        this.typeOfProductRepository = typeOfProductRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product, Long typeOfProductId) {
        Optional<TypeOfProduct> foundedTypeOfProduct  = typeOfProductRepository.findById(typeOfProductId); // check if type of product exists
        if (foundedTypeOfProduct.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        product.setTypeOfProduct(foundedTypeOfProduct.get());
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
    }

}
