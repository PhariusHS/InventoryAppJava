package com.pharius.inventoryapp.inventoryapp.Services.TypeOfProductServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Controllers.Query;
import com.pharius.inventoryapp.inventoryapp.Models.ProductModels.TypeOfProduct;
import com.pharius.inventoryapp.inventoryapp.Repositories.TypeOfProductRepository;

@Service
public class GetAllTypesOfProductsService implements Query<Void, List<TypeOfProduct>> {

    private final TypeOfProductRepository typeOfProductRepository;

    public GetAllTypesOfProductsService(TypeOfProductRepository typeOfProductRepository) {
        this.typeOfProductRepository = typeOfProductRepository;
    }

    @Override
    public ResponseEntity<List<TypeOfProduct>> execute(Void typesOfProducts) {

        List<TypeOfProduct> types = typeOfProductRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(types);

    }

}
