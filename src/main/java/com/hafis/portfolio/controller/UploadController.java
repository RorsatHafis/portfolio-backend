package com.hafis.portfolio.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hafis.portfolio.dto.response.ApiResponse;
import com.hafis.portfolio.dto.response.ImageResponseDTO;
import com.hafis.portfolio.service.UploadService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/uploads")
@RequiredArgsConstructor
public class UploadController {

    private final UploadService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(
        value = "/project/{projectId}",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ApiResponse<List<ImageResponseDTO>> upload (
        @PathVariable Long projectId,
        @RequestParam("files") List<MultipartFile> files
    ) {

        return ApiResponse.success(
            "Image uploaded successfully",
            service.upload(projectId, files)
        );

    }

    @GetMapping("/project/{projectId}")
    public ApiResponse<List<ImageResponseDTO>> getByProject (
        @PathVariable Long projectId
    ) {

        return ApiResponse.success(
            "Images retrieved successfully",
            service.getByProject(projectId)
        );

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{imageId}")
    public ApiResponse<Void> delete (
        @PathVariable Long imageId
    ) {

        service.delete(imageId);

        return ApiResponse.success(
            "Image deleted successfully",
            null
        );

    }
    
}
