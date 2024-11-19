package com.pharius.inventoryapp.inventoryapp.Controllers.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pharius.inventoryapp.inventoryapp.Entities.User.Role;
import com.pharius.inventoryapp.inventoryapp.Entities.User.User;
import com.pharius.inventoryapp.inventoryapp.Repositories.UserRepository;
import com.pharius.inventoryapp.inventoryapp.jwt.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public AuthResponse login(LoginRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    public AuthResponse register(RegisterRequest request) {
       
        User user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .firstName(request.getFirstName())
        .lastName(request.getLastName())
        .country(request.getCountry())
        .role(Role.USER)
        .build();

        String encodedPassword = passwordEncoder.encode(request.getPassword());
        System.out.println("Encoded Password: " + encodedPassword);

        userRepository.save(user);

        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }

}
