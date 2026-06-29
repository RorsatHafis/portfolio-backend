package com.hafis.portfolio.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hafis.portfolio.dto.request.ExperienceRequestDTO;
import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.dto.response.ExperienceResponseDTO;
import com.hafis.portfolio.service.ExperienceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService service;

    @GetMapping
    public ApiResponse<List<ExperienceResponseDTO>> getAll () {

        return ApiResponse.success(
            "Experience retrieved successfully",
            service.getAlls()
        );

    }

    @GetMapping("/{id}")
    public ApiResponse<ExperienceResponseDTO> getById (
        @PathVariable Long id
    ) {

        return ApiResponse.success(
            "Experience retrieved succcessfully",
            service.getById(id)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<ExperienceResponseDTO> create (
        @RequestBody @Valid ExperienceRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Experience created successfully", 
            service.create(requestDTO)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<ExperienceResponseDTO> update (
        @PathVariable Long id,
        @RequestBody ExperienceRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Experience updated successfully", 
            service.update(id, requestDTO)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete (
        @PathVariable Long id
    ) {

        service.delete(id);

        return ApiResponse.success(
            "Experience deleted successfully", 
            null
        );

    }
    
}
