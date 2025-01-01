package com.pharius.inventoryapp.inventoryapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.CreateRestockProductService;

public class CreateRestockProductServiceTest {

@Mock
private RestockProductRepository restockProductRepository;

@Mock
private ProductRepository productRepository;

@Mock
private EstablishmentRepository establishmentRepository;

@Mock
private RestockRepository restockRepository;


@InjectMocks
private CreateRestockProductService createRestockProductService;


@BeforeEach
public void setup(){
    MockitoAnnotations.openMocks(this);
}


@Test
public void given_valid_restock_product_when_create_service_invoked_then_returns_restock_product(){

    // Given
    Establishment establishment = new Establishment(1L, "Establishment 1", "Address 1");
    Product product = new Product(1L, "Product 1",  new TypeOfProduct(1L, "Type 1"));
    Restock restock = new Restock(1L, establishment, LocalDateTime.now(), Set.of(new RestockProduct()));



    RestockProduct restockProductToCreate = new RestockProduct(); // Create a restock product to simulate the request
    restockProductToCreate.setQuantity(10);
    restockProductToCreate.setProduct(product);
    restockProductToCreate.setRestock(restock);

    RestockProduct restockProductCreated = new RestockProduct(); // Expected response
    restockProductCreated.setId(1L);
    restockProductCreated.setQuantity(10);
    restockProductCreated.setRestock(restock);
    restockProductCreated.setProduct(product);

    // Simulate the repository responses
    when(restockRepository.findById(1L)).thenReturn(Optional.of(restock));
    when(productRepository.findById(1L)).thenReturn(Optional.of(product));
    when(restockProductRepository.save(restockProductToCreate)).thenReturn(restockProductCreated);
    // When
    ResponseEntity<RestockProduct> response = createRestockProductService.execute(restockProductToCreate, 1L, 1L);


    // Then
    assertEquals(HttpStatus.CREATED, response.getStatusCode()); // Check if the response is 201;
    verify(restockProductRepository, times(1)).save(restockProductToCreate);
}
}
