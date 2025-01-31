package com.pharius.inventoryapp.inventoryapp.Controllers.RestockControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.RestockDTO;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.UpdateRestockCommand;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.CreateRestockService;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.DeleteRestockService;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.GetAllRestocksService;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.GetRestockByIdService;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.UpdateRestockService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/restock")
public class RestockController {

    private final CreateRestockService createRestockService;
    private final GetRestockByIdService getRestockByIdService;
    private final GetAllRestocksService getAllRestocksService;
    private final UpdateRestockService updateRestockService;
    private final DeleteRestockService deleteRestockService;

    public RestockController(CreateRestockService createRestockService, GetAllRestocksService getAllRestocksService,
            UpdateRestockService updateRestockService, GetRestockByIdService getRestockByIdService, DeleteRestockService deleteRestockService) {
        this.createRestockService = createRestockService;
        this.getAllRestocksService = getAllRestocksService;
        this.updateRestockService = updateRestockService;
        this.getRestockByIdService = getRestockByIdService;
        this.deleteRestockService = deleteRestockService;
    }

    @GetMapping
    public ResponseEntity<List<Restock>> getAllRestocks() {
        return getAllRestocksService.execute(null);
    }
    @GetMapping("/{restockId}")
    public ResponseEntity<RestockDTO> getRestockById(@PathVariable Long restockId) {
        return getRestockByIdService.execute(restockId);
    }
    @PostMapping
    public ResponseEntity<RestockDTO> createRestock(@RequestBody Restock restock, @RequestParam Long establishmentId) {
        return createRestockService.execute(restock, establishmentId);

    }
    @PutMapping("/{restockId}")
    public ResponseEntity<RestockDTO> updateRestock(@PathVariable Long restockId, @RequestBody Restock restockDetails) {
        return updateRestockService.execute(new UpdateRestockCommand(restockId, restockDetails));
    }
    @DeleteMapping("/{restockId}")
    public ResponseEntity<Void> deleteRestock(@PathVariable Long restockId) {
        return deleteRestockService.execute(restockId);
    }
}
