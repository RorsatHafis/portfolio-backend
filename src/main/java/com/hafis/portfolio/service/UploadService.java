package com.hafis.portfolio.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hafis.portfolio.dto.response.ImageResponseDTO;

public interface UploadService {

    List<ImageResponseDTO> upload (
        Long projectId,
        List<MultipartFile> files
    );

    List<ImageResponseDTO> getByProject (
        Long projectId
    );

    void delete (Long imageId);
    
}
