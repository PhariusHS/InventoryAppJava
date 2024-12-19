package com.pharius.inventoryapp.inventoryapp.Controllers.EstablishmentControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.EstablishmentDTO;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.CreateEstablishmentService;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.GetAllEstablishmentsService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    private final GetAllEstablishmentsService getAllEstablishmentsService;
    private final CreateEstablishmentService CreateEstablishmentService;

    public EstablishmentController(GetAllEstablishmentsService getAllEstablishmentsService, CreateEstablishmentService CreateEstablishmentService) {
        this.getAllEstablishmentsService = getAllEstablishmentsService;
        this.CreateEstablishmentService = CreateEstablishmentService;
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> getAllEstablishments() {
        return getAllEstablishmentsService.execute(null);
    }

    @PostMapping
    public ResponseEntity<EstablishmentDTO> crateEstablishment(@RequestBody Establishment establishment) {
        return CreateEstablishmentService.execute(establishment);
    }

}
