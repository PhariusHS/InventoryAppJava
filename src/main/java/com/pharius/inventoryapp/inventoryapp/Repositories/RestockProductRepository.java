package com.pharius.inventoryapp.inventoryapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;

public interface RestockProductRepository extends JpaRepository<RestockProduct, Long> {
    
}
