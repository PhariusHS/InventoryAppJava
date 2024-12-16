package com.pharius.inventoryapp.inventoryapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;

public interface RestockRepository extends JpaRepository<Restock, Long> {
    
}
