package com.pharius.inventoryapp.inventoryapp.Controllers.EstablishmentControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.GetAllEstablishmentsService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    private final GetAllEstablishmentsService getAllEstablishmentsService;

    public EstablishmentController(GetAllEstablishmentsService getAllEstablishmentsService) {
        this.getAllEstablishmentsService = getAllEstablishmentsService;
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> getAllEstablishments() {
        return getAllEstablishmentsService.execute(null);
    }

}
