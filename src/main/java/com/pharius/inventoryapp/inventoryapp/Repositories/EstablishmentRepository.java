package com.pharius.inventoryapp.inventoryapp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
    
}
