package com.hafis.portfolio.service.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.hafis.portfolio.dto.request.LoginRequestDTO;
import com.hafis.portfolio.dto.response.LoginResponseDTO;
import com.hafis.portfolio.entity.User;
import com.hafis.portfolio.exception.UnauthorizedException;
import com.hafis.portfolio.exception.UserNotFoundException;
import com.hafis.portfolio.repository.UserRepository;
import com.hafis.portfolio.security.JwtService;
import com.hafis.portfolio.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;
    private final UserRepository repository;
    private final JwtService jwtService;

    @Override
    public LoginResponseDTO login (LoginRequestDTO requestDTO) {

        try {

            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    requestDTO.getUsername(), requestDTO.getPassword()
                )
            );

        } catch (AuthenticationException e) {

            new UnauthorizedException("Invalid username or password");

        }

        User user = repository.findByUsername(requestDTO.getUsername())
                        .orElseThrow(() -> new UserNotFoundException(
                            "User not found"
                        ));

        String token = jwtService.generateToken(user);

        return LoginResponseDTO.builder()
                    .token(token)
                    .type("Bearer")
                    .username(user.getUsername())
                    .role(user.getRole().name())
                    .build();

    }
    
}
