package com.pharius.inventoryapp.inventoryapp.Services.InventoryServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.RelationalCommand;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.Inventory;
import com.pharius.inventoryapp.inventoryapp.Models.InventoryModels.InventoryDTO;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;
import com.pharius.inventoryapp.inventoryapp.Repositories.InventoryRepository;
import com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices.GetEstablishmentByIdService;

@Service
public class CreateInventoryService implements RelationalCommand<Inventory, InventoryDTO, Long> {

    private final InventoryRepository inventoryRepository;
    private final EstablishmentRepository establishmentRepository;

    public CreateInventoryService(InventoryRepository inventoryRepository,
            EstablishmentRepository establishmentRepository, GetEstablishmentByIdService getEstablishmentByIdService) {
        this.inventoryRepository = inventoryRepository;
        this.establishmentRepository = establishmentRepository;

    }

    @Override
    public ResponseEntity<InventoryDTO> execute(Inventory inventory, Long establishmentId) {
        Optional<Establishment> foundedEstablishment = establishmentRepository.findById(establishmentId);
        if (foundedEstablishment.isPresent()) {
            inventory.setEstablishment(foundedEstablishment.get());
            Inventory createdInventory = inventoryRepository.save(inventory);
            return ResponseEntity.status(HttpStatus.CREATED).body(new InventoryDTO(createdInventory));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Establishment");
    }
}
