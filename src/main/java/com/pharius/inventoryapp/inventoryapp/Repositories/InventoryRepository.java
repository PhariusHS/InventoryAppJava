package com.pharius.inventoryapp.inventoryapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {


    
    
}
