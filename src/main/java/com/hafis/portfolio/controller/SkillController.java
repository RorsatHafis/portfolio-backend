package com.hafis.portfolio.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hafis.portfolio.dto.request.SkillRequestDTO;
import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.dto.response.SkillResponseDTO;
import com.hafis.portfolio.service.SkillService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService service;

    @GetMapping
    public ApiResponse<List<SkillResponseDTO>> getAll () {

        return ApiResponse.success(
            "Skills retrieved successfully",
            service.getAlls()
        );

    }

    @GetMapping("/{id}")
    public ApiResponse<SkillResponseDTO> getById (
        @PathVariable Long id
    ) {

        return ApiResponse.success(
            "Skill retrieved succcessfully",
            service.getById(id)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ApiResponse<SkillResponseDTO> create (
        @RequestBody @Valid SkillRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Skill created successfully", 
            service.create(requestDTO)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ApiResponse<SkillResponseDTO> update (
        @PathVariable Long id,
        @RequestBody SkillRequestDTO requestDTO
    ) {

        return ApiResponse.success(
            "Skill updated successfully", 
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
            "Skill deleted successfully", 
            null
        );

    }
    
}
