package com.pharius.inventoryapp.inventoryapp.Controllers.ProductControllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.Product;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.ProductDTO;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.UpdateProductCommand;
import com.pharius.inventoryapp.inventoryapp.Services.ProductServices.CreateProductService;
import com.pharius.inventoryapp.inventoryapp.Services.ProductServices.DeleteProductService;
import com.pharius.inventoryapp.inventoryapp.Services.ProductServices.GetAllProductsService;
import com.pharius.inventoryapp.inventoryapp.Services.ProductServices.GetProductByIdService;
import com.pharius.inventoryapp.inventoryapp.Services.ProductServices.UpdateProductService;

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
    // Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return getAllProductsService.execute(null);
    }
    // Get one product
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long productId) {

        return getProductByIdService.execute(productId);

    }
    // Post a new product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product, @RequestParam Long typeOfProductId) {

        return createProductService.execute(product, typeOfProductId);

    }
    // Update a product by productId
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long productId, @RequestBody Product productDetails) {
        return updateProductService.execute(new UpdateProductCommand(productId, productDetails));
    }
    // Delete product
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {

        return deleteProductService.execute(productId);

    }
}
