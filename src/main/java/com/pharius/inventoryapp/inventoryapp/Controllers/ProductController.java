package com.pharius.inventoryapp.inventoryapp.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Entities.Product.Model.Product;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Model.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Services.CreateProductService;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Services.DeleteProductService;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Services.GetAllProductsService;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Services.GetProductByIdService;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Services.UpdateProductCommand;
import com.pharius.inventoryapp.inventoryapp.Entities.Product.Services.UpdateProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final GetAllProductsService getAllProductsService;
    private final GetProductByIdService getProductByIdService;
    private final CreateProductService createProductService;
    private final DeleteProductService deleteProductService;
    private final UpdateProductService updateProductService;

    public ProductController(GetAllProductsService getAllProductsService,
            GetProductByIdService getProductByIdService, DeleteProductService deleteProductService,
            UpdateProductService updateProductService, CreateProductService createProductService) {

        this.getAllProductsService = getAllProductsService;
        this.getProductByIdService = getProductByIdService;
        this.deleteProductService = deleteProductService;
        this.createProductService = createProductService;
        this.updateProductService = updateProductService;

    }

    // Get all prdocuts
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return getAllProductsService.execute(null);
    }

    // Get one product
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {

        return getProductByIdService.execute(productId);

    }

    // Post a new product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {

        return createProductService.execute(product);

    }

    // Update a product by productId
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long productId, @RequestBody Product productDetails) {

        return updateProductService.execute(new UpdateProductCommand(productId, productDetails));

    }

    // Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {

        return deleteProductService.execute(productId);

    }
}
