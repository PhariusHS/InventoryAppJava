package com.pharius.inventoryapp.inventoryapp.Models.InventoryModels;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class InventoryProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // One inventory product can belong to one product - Every product has many inventory products
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne // One inventory product can belong to one inventory - Every inventory has many inventory products
    @JoinColumn(name = "inventory_id")
    @JsonIgnore // fix recursion 
    private Inventory inventory;

    private Integer stock;


}
