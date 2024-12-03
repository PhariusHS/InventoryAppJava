package com.pharius.inventoryapp.inventoryapp.Entities.Product.Model;

import com.pharius.inventoryapp.inventoryapp.Entities.Establishment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerated method
    private Long stockId;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Establishment establishment;

    
    private int quantity;




}