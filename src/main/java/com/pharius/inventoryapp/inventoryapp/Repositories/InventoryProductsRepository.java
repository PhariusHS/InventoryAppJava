package com.pharius.inventoryapp.inventoryapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;

public interface InventoryProductsRepository extends JpaRepository<InventoryProducts, Long> {
    
    

}
