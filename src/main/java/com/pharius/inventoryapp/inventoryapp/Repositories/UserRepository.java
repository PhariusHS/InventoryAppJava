package com.pharius.inventoryapp.inventoryapp.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pharius.inventoryapp.inventoryapp.Entities.User.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    
}
