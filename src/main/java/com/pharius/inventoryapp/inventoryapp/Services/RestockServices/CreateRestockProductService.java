package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.DoubleRelationalCommand;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Exceptions.QuantityNotAvailableException;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProductDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryProductsRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockProductRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

@Service
public class CreateRestockProductService
        implements DoubleRelationalCommand<RestockProduct, RestockProductDTO, Long, Long> {

    private final RestockProductRepository restockProductRepository;
    private final InventoryProductsRepository inventoryProductsRepository;
    private final RestockRepository restockRepository;
    private final InventoryRepository inventoryRepository;

    public CreateRestockProductService(RestockProductRepository restockProductRepository,
            InventoryProductsRepository inventoryProductsRepository, RestockRepository restockRepository,
            InventoryRepository inventoryRepository) {
        this.restockProductRepository = restockProductRepository;
        this.inventoryProductsRepository = inventoryProductsRepository;
        this.restockRepository = restockRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public ResponseEntity<RestockProductDTO> execute(RestockProduct restockProduct, Long inventoryProductId, Long restockId) {
        Optional<Restock> foundedRestock = restockRepository.findById(restockId);
        Optional<InventoryProducts> foundedinventoryProducts = inventoryProductsRepository.findById(inventoryProductId);

        if (!foundedinventoryProducts.isPresent()) {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Inventory product");
        }
        if (!foundedRestock.isPresent()) {
            throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Restock");
        }

        if(foundedinventoryProducts.get().getStock() < restockProduct.getQuantity()){
            throw new QuantityNotAvailableException(ErrorMessages.QUANTITY_NOT_AVAILABLE, "Inventory product");
        }


        restockProduct.setInventoryProduct(foundedinventoryProducts.get());
        restockProduct.setRestock(foundedRestock.get());
        restockProductRepository.save(restockProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(new RestockProductDTO(restockProduct));
    }

}
