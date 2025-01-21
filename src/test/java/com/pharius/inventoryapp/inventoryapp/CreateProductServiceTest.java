package com.pharius.inventoryapp.inventoryapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;
import com.pharius.inventoryapp.inventoryapp.Services.ProductServices.CreateProductService;

public class CreateProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private TypeOfProductRepository typeOfProductRepository;
    
    @InjectMocks
    private CreateProductService createProductService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initialize the repository and the service
    }

    @Test
    public void given_valid_product_when_create_service_invoked_then_returns_product_dto() {

        // Given
        TypeOfProduct typeOfProduct = new TypeOfProduct(1L, "Type 1");

        Product productToCreate = new Product(); // Create a product to simulate the request
        productToCreate.setName("Product 1");
        productToCreate.setTypeOfProduct(typeOfProduct);

        Product productCreated = new Product(); // Expected response from the service
        productCreated.setProductId(1L);
        productCreated.setName("Product 1");
        productCreated.setTypeOfProduct(typeOfProduct);

        when(typeOfProductRepository.findById(1L)).thenReturn(Optional.of(typeOfProduct)); // Simulate the response of the repository
        when(productRepository.save(productToCreate)).thenReturn(productCreated);
        // When
        ResponseEntity<ProductDTO> response = createProductService.execute(productToCreate, 1l);

        // Then
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(productCreated)), response);
        verify(productRepository, times(1)).save(productToCreate);

    }

}
