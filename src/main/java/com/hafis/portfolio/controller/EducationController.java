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

import com.hafis.portfolio.dto.request.EducationRequestDTO;
import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.dto.response.EducationResponseDTO;
import com.hafis.portfolio.service.EducationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService service;

    @GetMapping
    public ApiResponse<List<EducationResponseDTO>> getAll () {

        return ApiResponse.success(
            "Education retrieved successfully",
            service.getAlls()
        );

    }

    @GetMapping("/{id}")
    public ApiResponse<EducationResponseDTO> getById (
        @PathVariable Long id
    ) {

        return ApiResponse.success(
            "Education retrieved succcessfully",
            service.getById(id)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<EducationResponseDTO> create (
        @RequestBody @Valid EducationRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Education created successfully", 
            service.create(requestDTO)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<EducationResponseDTO> update (
        @PathVariable Long id,
        @RequestBody EducationRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Education updated successfully", 
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
            "Education deleted successfully", 
            null
        );

    }
    
}
