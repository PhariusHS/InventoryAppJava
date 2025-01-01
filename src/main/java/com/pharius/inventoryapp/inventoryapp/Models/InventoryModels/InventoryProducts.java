package com.pharius.inventoryapp.inventoryapp.Models.InventoryModels;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // One inventory product can belong to one product - Every product has many inventory products
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne // One inventory product can belong to one inventory - Every inventory has many inventory products
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    private int quantity;

    
}
