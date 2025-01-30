package com.pharius.inventoryapp.inventoryapp.Services.EstablishmentServices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Command;
import com.pharius.inventoryapp.inventoryapp.Exceptions.EntityNotFoundException;
import com.pharius.inventoryapp.inventoryapp.Exceptions.ErrorMessages;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.Establishment;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.EstablishmentDTO;
import com.pharius.inventoryapp.inventoryapp.Models.EstablishmentModels.UpdateEstablishmentCommand;
import com.pharius.inventoryapp.inventoryapp.Repositories.EstablishmentRepository;

@Service
public class UpdateEstablishmentService implements Command<UpdateEstablishmentCommand, EstablishmentDTO> {

    private final EstablishmentRepository establishmentRepository;

    public UpdateEstablishmentService(EstablishmentRepository establishmentRepository){
        this.establishmentRepository = establishmentRepository;
    }

    @Override
    public ResponseEntity<EstablishmentDTO> execute(UpdateEstablishmentCommand updateEstablishmentCommand) {

        Optional<Establishment> foundedEstablishment = establishmentRepository.findById(updateEstablishmentCommand.getId());
        if(foundedEstablishment.isPresent()){
        Establishment existingEstablishment = foundedEstablishment.get();
        existingEstablishment.setEstablishmentId(updateEstablishmentCommand.getId());
        Establishment updatedEstablishment = establishmentRepository.save(existingEstablishment);
        return ResponseEntity.status(HttpStatus.OK).body(new EstablishmentDTO(updatedEstablishment));
        }
        throw new EntityNotFoundException(ErrorMessages.ENTITY_NOT_FOUND, "Establishment");
    }
    

}
