package com.pharius.inventoryapp.inventoryapp.Services.ProductServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;

@Service
public class GetAllProductsService implements Query<Void, List<Product>> {

    private final ProductRepository productRepository;

    public GetAllProductsService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> execute(Void input) {
        List<Product> products = productRepository.findAll();
        //If there's not products just returns an empty list
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

}
