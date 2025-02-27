package com.pharius.inventoryapp.inventoryapp.Services.AuthServices;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import com.pharius.inventoryapp.inventoryapp.Controllers.AuthControllers.AuthResponse;
import com.pharius.inventoryapp.inventoryapp.Controllers.AuthControllers.LoginRequest;
import com.pharius.inventoryapp.inventoryapp.Controllers.AuthControllers.RegisterRequest;
import com.pharius.inventoryapp.inventoryapp.Models.UserModels.Role;
import com.pharius.inventoryapp.inventoryapp.Models.UserModels.User;
import com.pharius.inventoryapp.inventoryapp.Repositories.UserRepository;
import com.pharius.inventoryapp.inventoryapp.jwt.JwtService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {


    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
        .message("Successfully log in")
        .token(token)
        .build();
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


        userRepository.save(user);

        return AuthResponse.builder()
        .message("User successfully created")
        .token(jwtService.getToken(user))
        .build();
    }

}
