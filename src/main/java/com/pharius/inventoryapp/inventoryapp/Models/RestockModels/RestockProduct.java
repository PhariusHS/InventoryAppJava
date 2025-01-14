package com.pharius.inventoryapp.inventoryapp.Models.RestockModels;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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
    @JoinColumn(name ="product_id")
    private Product product;

    @ManyToOne // One restock product can belong to one restock - Every restock has many restock products
    @JoinColumn(name="restock_id")
    private Restock restock;

    private int quantity;
    
    public RestockProduct(RestockProduct restockProduct) {
        this.id = restockProduct.getId();
        this.product = restockProduct.getProduct();
        this.restock = restockProduct.getRestock();
        this.quantity = restockProduct.getQuantity();
    }


}
