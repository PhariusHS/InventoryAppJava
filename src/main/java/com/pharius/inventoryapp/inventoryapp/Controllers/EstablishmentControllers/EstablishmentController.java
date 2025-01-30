package com.pharius.inventoryapp.inventoryapp.Controllers.EstablishmentControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.EstablishmentDTO;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.UpdateEstablishmentCommand;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.CreateEstablishmentService;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.DeleteEstablishmentService;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.GetAllEstablishmentsService;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.GetEstablishmentByIdService;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.UpdateEstablishmentService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/establishments")
public class EstablishmentController {

    private final GetAllEstablishmentsService getAllEstablishmentsService;
    private final GetEstablishmentByIdService getEstablishmentByIdService;
    private final CreateEstablishmentService createEstablishmentService;
    private final UpdateEstablishmentService updateEstablishmentService;
    private final DeleteEstablishmentService deleteEstablishmentService;

    public EstablishmentController(GetAllEstablishmentsService getAllEstablishmentsService,
            CreateEstablishmentService createEstablishmentService,
            GetEstablishmentByIdService getEstablishmentByIdService,
            UpdateEstablishmentService updateEstablishmentService,
            DeleteEstablishmentService deleteEstablishmentService) {
        this.getAllEstablishmentsService = getAllEstablishmentsService;
        this.createEstablishmentService = createEstablishmentService;
        this.getEstablishmentByIdService = getEstablishmentByIdService;
        this.updateEstablishmentService = updateEstablishmentService;
        this.deleteEstablishmentService = deleteEstablishmentService;
    }

    @GetMapping
    public ResponseEntity<List<Establishment>> getAllEstablishments() {
        return getAllEstablishmentsService.execute(null);
    }
    @GetMapping("/{establishmentId}")
    public ResponseEntity<EstablishmentDTO> getEstablishmentById(@PathVariable Long establishmentId) {
        return getEstablishmentByIdService.execute(establishmentId);
    }
    @PostMapping
    public ResponseEntity<EstablishmentDTO> crateEstablishment(@RequestBody Establishment establishment) {
        return createEstablishmentService.execute(establishment); 
    }
    @PutMapping("/{establishmentId}")
    public ResponseEntity<EstablishmentDTO> updateEstablishment(@PathVariable Long establishmentId, @RequestBody Establishment establishment) {
     return updateEstablishmentService.execute(new UpdateEstablishmentCommand(establishmentId, establishment));
    }
    @DeleteMapping("/{establishmentId}")
    public ResponseEntity<Void> deleteEstablishment(@PathVariable Long establishmentId){
        return deleteEstablishmentService.execute(establishmentId);
    }
}
