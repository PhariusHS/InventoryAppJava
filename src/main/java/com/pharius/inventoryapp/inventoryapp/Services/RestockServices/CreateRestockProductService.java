package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.DoubleRelationalCommand;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProductDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

@Service
public class CreateRestockProductService
        implements DoubleRelationalCommand<RestockProduct, RestockProductDTO, Long, Long> {

    private final RestockProductRepository restockProductRepository;
    private final ProductRepository productRepository;
    private final RestockRepository restockRepository;

    public CreateRestockProductService(RestockProductRepository restockProductRepository,
            ProductRepository productRepository, RestockRepository restockRepository) {
        this.restockProductRepository = restockProductRepository;
        this.productRepository = productRepository;
        this.restockRepository = restockRepository;
    }

    @Override
    public ResponseEntity<RestockProductDTO> execute(RestockProduct restockProduct, Long productId, Long restockId) {
        Optional<Restock> foundedRestock = restockRepository.findById(restockId);
        Optional<Product> foundedProduct = productRepository.findById(productId);

        if (!foundedProduct.isPresent()) {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Product");
        }
        if (!foundedRestock.isPresent()){
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Restock");
        }
        restockProduct.setProduct(foundedProduct.get());
        restockProduct.setRestock(foundedRestock.get());
        restockProductRepository.save(restockProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestockProductDTO(restockProduct));
    }

}
