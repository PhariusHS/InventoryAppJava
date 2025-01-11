package com.pharius.inventoryapp.inventoryapp.Controllers.RestockPorductControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.CreateRestockProductService;

@RestController
@RequestMapping("/restock/product")
public class RestockProductControllers {

    private final CreateRestockProductService createRestockProductService;

    public RestockProductControllers(CreateRestockProductService createRestockProductService) {
        this.createRestockProductService = createRestockProductService;
    }

    @PostMapping
    public ResponseEntity<RestockProduct> createRestockProduct(@RequestBody RestockProduct restockProduct,
            @RequestParam Long productId, @RequestParam Long restockId) {
        return createRestockProductService.execute(restockProduct, productId, restockId);
    }

}
