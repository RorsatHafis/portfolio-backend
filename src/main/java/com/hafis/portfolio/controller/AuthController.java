package com.hafis.portfolio.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hafis.portfolio.dto.request.LoginRequestDTO;
import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.dto.response.LoginResponseDTO;
import com.hafis.portfolio.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/login")
    public ApiResponse<LoginResponseDTO> login (
        @RequestBody @Valid LoginRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Login successful",
            service.login(requestDTO)
        );

    }
    
}
