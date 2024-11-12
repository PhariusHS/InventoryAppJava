package com.pharius.inventoryapp.inventoryapp.Controllers.auth;

import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Entities.User.Role;
import com.pharius.inventoryapp.inventoryapp.Entities.User.User;
import com.pharius.inventoryapp.inventoryapp.Repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;

    public AuthResponse login(LoginRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public AuthResponse register(RegisterRequest request) {
       
        User user = User.builder()
        .username(request.getUsername())
        .password(request.getPassword())
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .country(request.getCountry())
        .role(Role.USER)
        .build();

        userRepository.save(user);

        return AuthResponse.builder()
        .token(null)
        .build();
    }

}
