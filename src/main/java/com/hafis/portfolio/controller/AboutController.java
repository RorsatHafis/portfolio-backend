package com.hafis.portfolio.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hafis.portfolio.dto.request.AboutRequestDTO;
import com.hafis.portfolio.dto.response.AboutResponseDTO;
import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.service.AboutService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {
    
    private final AboutService service;

    @GetMapping
    public ApiResponse<AboutResponseDTO> get () {

        return ApiResponse.success(
            "About retrieved successfully",
            service.get()
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<AboutResponseDTO> save (
        @RequestBody @Valid AboutRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "About saved successfully",
            service.save(requestDTO)
        );

    }
    
}
