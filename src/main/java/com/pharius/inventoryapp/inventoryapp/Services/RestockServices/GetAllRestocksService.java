package com.pharius.inventoryapp.inventoryapp.Services.RestockServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.RestockModels.Restock;
import com.pharius.inventoryapp.inventoryapp.Repositories.RestockRepository;

@Service
public class GetAllRestocksService implements Query<Void, List<Restock>> {

    private final RestockRepository restockRepository;

    public GetAllRestocksService(RestockRepository restockRepository) {
        this.restockRepository = restockRepository;
    }

    @Override
    public ResponseEntity<List<Restock>> execute(Void input) {

        List<Restock> restocks = restockRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(restocks);
    }
}
