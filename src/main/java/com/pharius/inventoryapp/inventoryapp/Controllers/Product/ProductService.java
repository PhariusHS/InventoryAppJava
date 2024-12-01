package com.pharius.inventoryapp.inventoryapp.Controllers.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Entities.Product.Product;
import com.pharius.inventoryapp.inventoryapp.Repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
        .orElseThrow( () -> new RuntimeException("The product with the productId " + productId + " doesn't exist")); //Error handling, not getting product with the productId
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long productId){

        //Get the product to delete by productId
        Product product = productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("The product with the productId " + productId + "doesn't exist")); //Error handling not getting productId

        //delete the product
        productRepository.delete(product);

    }

    public Product updateProduct( Long productId, Product productDetails){
        
        
        //Get the product by productId
        Product product = productRepository.findById(productId)
        .orElseThrow(() -> new RuntimeException("The product with the productId " + productId + " doesn't exist")); //Error handling not getting productId

        //Update the product
        product.setName(productDetails.getName());

        //Saves and returns the new product
        return productRepository.save(product);

    }

}
