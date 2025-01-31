package com.pharius.inventoryapp.inventoryapp.Models.RestockModels;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryProducts;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // prevents infinite loop 
public class RestockProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne // One restock product can belong to one product - Every product has many restock products
    @JoinColumn(name ="inventory_product_id")
    private InventoryProducts inventoryProduct;

    @ManyToOne // One restock product can belong to one restock - Every restock has many restock products
    @JoinColumn(name="restock_id")
    @JsonIgnore // fix recursion 
    private Restock restock;

    @Positive(message = "Restocked product has to be at least 1")
    private int quantity;

}
