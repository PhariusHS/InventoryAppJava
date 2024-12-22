package com.pharius.inventoryapp.inventoryapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;

public interface TypeOfProductRepository extends JpaRepository<TypeOfProduct, Long> {
    
}
