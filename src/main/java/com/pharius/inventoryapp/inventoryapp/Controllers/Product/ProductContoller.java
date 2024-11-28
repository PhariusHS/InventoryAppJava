package com.pharius.inventoryapp.inventoryapp.Controllers.Product;

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

import com.pharius.inventoryapp.inventoryapp.Entities.Product;

@RestController
@RequestMapping("/products")
public class ProductContoller {

    @Autowired
    private ProductService productService;

    //Get all prdocuts
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //Get one product
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        //Get the product by id
        return productService.getProductById(id);
    }

    //Post a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        return productService.createProduct(product);

    }

    //Update a product by id
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        
        return productService.updateProduct(id, productDetails);

    }

    //Delete product
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
      
    }
}
