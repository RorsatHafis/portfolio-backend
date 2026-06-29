package com.hafis.portfolio.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hafis.portfolio.dto.request.ContactRequestDTO;
import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.dto.response.ContactResponseDTO;
import com.hafis.portfolio.service.ContactService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService service;

    @GetMapping
    public ApiResponse<ContactResponseDTO> get () {

        return ApiResponse.success(
            "Contact retrieved successfully",
            service.get()
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<ContactResponseDTO> save (
        @RequestBody @Valid ContactRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Contact saved successfully",
            service.save(requestDTO)
        );

    }
    
}
