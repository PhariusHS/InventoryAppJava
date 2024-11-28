package com.pharius.inventoryapp.inventoryapp.Controllers.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Entities.Product;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
        .orElseThrow( () -> new RuntimeException("The product with the id " + id + " doesn't exist")); //Error handling, not getting product with the id
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id){

        //Get the product to delete by id
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with the id " + id + "doesn't exist")); //Error handling not getting id

        //delete the product
        productRepository.delete(product);

    }

    public Product updateProduct( Long id, Product productDetails){
        
        
        //Get the product by id
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with the id " + id + " doesn't exist")); //Error handling not getting id

        //Update the product
        product.setName(productDetails.getName());
        product.setStock(productDetails.getStock());

        //Saves and returns the new product
        return productRepository.save(product);

    }

}
