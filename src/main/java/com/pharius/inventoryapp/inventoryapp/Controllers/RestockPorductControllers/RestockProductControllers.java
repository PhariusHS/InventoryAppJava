package com.pharius.inventoryapp.inventoryapp.Controllers.RestockPorductControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProduct;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockProductDTO;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.UpdateRestockProductCommand;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.CreateRestockProductService;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.DeleteRestockProductService;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.UpdateRestockProductService;

@RestController
@RequestMapping("/restock/product")
public class RestockProductControllers {

    private final CreateRestockProductService createRestockProductService;
    private final DeleteRestockProductService deleteRestockProductService;
    private final UpdateRestockProductService updateRestockProductService;

    public RestockProductControllers(CreateRestockProductService createRestockProductService,
            DeleteRestockProductService deleteRestockProductService, UpdateRestockProductService updateRestockProductService) {
        this.createRestockProductService = createRestockProductService;
        this.deleteRestockProductService = deleteRestockProductService;
        this.updateRestockProductService = updateRestockProductService;
    }
    @PostMapping
    public ResponseEntity<RestockProductDTO> createRestockProduct(@RequestBody RestockProduct restockProduct,
            @RequestParam Long inventoryProductId, @RequestParam Long restockId) {
        return createRestockProductService.execute(restockProduct, inventoryProductId, restockId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RestockProductDTO> updateRestockProduct(@PathVariable Long id, @RequestBody RestockProduct restockProductDetails){
        return updateRestockProductService.execute(new UpdateRestockProductCommand(id, restockProductDetails));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestockProduct(@PathVariable Long restockProductId) {
        return deleteRestockProductService.execute(restockProductId);
    }
}
