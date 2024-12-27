package com.pharius.inventoryapp.inventoryapp.Controllers.RestockControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.CreateRestockService;
import com.pharius.inventoryapp.inventoryapp.Services.RestockServices.GetAllRestocksService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/restock")
public class RestockController {

    private final CreateRestockService createRestockService;
    private final GetAllRestocksService getAllRestocksService;


    public RestockController(CreateRestockService createRestockService, GetAllRestocksService getAllRestocksService) {
        this.createRestockService = createRestockService;
        this.getAllRestocksService = getAllRestocksService;
    }


    @GetMapping
    public ResponseEntity<List<Restock>> getAllRestocks() {
        return getAllRestocksService.execute(null);
    }
    

    @PostMapping
    public ResponseEntity<Restock> createRestock(@RequestBody Restock restock, @RequestParam Long establishmentId) {
        return createRestockService.execute(restock, establishmentId);
    }
    



    
}
