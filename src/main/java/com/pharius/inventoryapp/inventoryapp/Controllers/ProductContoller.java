package com.pharius.inventoryapp.inventoryapp.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;
import com.pharius.inventoryapp.inventoryapp.Entities.Product;

@RestController
@RequestMapping("/products")
public class ProductContoller {

    @Autowired
    private ProductRepository productRepository;

    //Get all prdocuts
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //Get one product
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        //Get the product by id
        return productRepository.findById(id)
        .orElseThrow( () -> new RuntimeException("The product with the id " + id + " doesn't exist")); //Error handling not getting id
    }

    //Post a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return productRepository.save(product);

    }

    //Update a product by id
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        
        
        //Get the product by id
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with the id " + id + " doesn't exist")); //Error handling not getting id

        //Update the product
        product.setName(productDetails.getName());
        product.setStock(productDetails.getStock());

        //Saves and returns the new product
        return productRepository.save(product);
    }

    //Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){

        //Get the product to delete by id
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with the id " + id + "doesn't exist")); //Error handling not getting id

        //delete the product
        productRepository.delete(product);

    }
}
