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
import org.springframework.http.ResponseEntity;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Services.ProductServices.GetProductByIdService;

public class GetProductServiceTest {

    @Mock // What to mock the response of
    private ProductRepository productRepository;

    @InjectMocks // What is being tested
    private GetProductByIdService getProductService;

    @BeforeEach // What is need to be set up before each test
    public void setup(){
        // Initialize the repository and the service
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void given_product_exists_when_get_product_service_return_product_dto(){
        // Given
        TypeOfProduct typeOfProduct = new TypeOfProduct(1L, "Type 1");

        Product product = new Product();
        product.setProductId(1L);
        product.setName("Product 1");
        product.setTypeOfProduct(typeOfProduct);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product)); // When the method findById is called with 1L as parameter, return the product 

        // When
        ResponseEntity<ProductDTO> response = getProductService.execute(1L); // Call the method

        // Then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)), response); // Verify that the response is the same as the expected response
        verify(productRepository, times(1)).findById(1L); // Verify that the method was called once

    }


    
}
