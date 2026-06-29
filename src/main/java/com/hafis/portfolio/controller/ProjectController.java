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

import com.hafis.portfolio.dto.request.ProjectRequestDTO;
import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.dto.response.ProjectResponseDTO;
import com.hafis.portfolio.service.ProjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @GetMapping
    public ApiResponse<List<ProjectResponseDTO>> getAlls () {

        return ApiResponse.success(
            "Project Retrieved successfully",
            service.getAlls()
        );

    }

    @GetMapping("/{id}")
    public ApiResponse<ProjectResponseDTO> getById (
        @PathVariable Long id
    ) {

        return ApiResponse.success(
            "Project Retrieved successfully",
            service.getById(id)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<ProjectResponseDTO> create (
        @RequestBody @Valid ProjectRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Project created successfully",
            service.create(requestDTO)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<ProjectResponseDTO> update (
        @PathVariable Long id,
        @RequestBody @Valid ProjectRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Project updated successfully",
            service.update(id, requestDTO)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete (
        @PathVariable Long id
    ) {

        return ApiResponse.success(
            "Project deleted successfully",
            null);

    }
    
}
