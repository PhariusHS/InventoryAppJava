package com.pharius.inventoryapp.inventoryapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{



}
