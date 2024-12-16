package com.pharius.inventoryapp.inventoryapp.Models;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Establishment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerated method
    private Long establishmentId;
    private String name;
    private String location;

    @OneToOne(mappedBy = "establishment") // Bidirectional relationship
    private Inventory inventory; // Inventory of the establishment
} 
