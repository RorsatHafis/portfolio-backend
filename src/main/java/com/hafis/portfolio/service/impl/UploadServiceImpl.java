package com.hafis.portfolio.service.impl;
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
 
import com.hafis.portfolio.exception.FileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
 
import com.hafis.portfolio.dto.response.ImageResponseDTO;
import com.hafis.portfolio.entity.Image;
import com.hafis.portfolio.entity.Project;
import com.hafis.portfolio.exception.ResourceNotFoundException;
import com.hafis.portfolio.repository.ImageRepository;
import com.hafis.portfolio.repository.ProjectRepository;
import com.hafis.portfolio.service.UploadService;
 
import lombok.RequiredArgsConstructor;
 
@Service
@RequiredArgsConstructor
@Transactional
public class UploadServiceImpl implements UploadService {
 
    private final ImageRepository imageRepository;
    private final ProjectRepository projectRepository;
    private static final String UPLOAD_DIR = "uploads";
    private static final List<String> ALLOWED_TYPES = List.of(
                                        "image/jpeg", "image/png", "image/webp", "image/gif"
                                    );
 
    @Override
    public List<ImageResponseDTO> upload (
        Long projectId,
        List<MultipartFile> files
    ) {
 
        Project project = projectRepository.findById(projectId)
                            .orElseThrow(() -> new ResourceNotFoundException(
                                "Project not found"
                            ));
 
        List<ImageResponseDTO> responses = new ArrayList<>();
 
        try {
 
            Files.createDirectories(Paths.get(UPLOAD_DIR));
 
        } catch (IOException e) {
 
            throw new RuntimeException("Cannot create upload folder");
 
        }
 
        for (MultipartFile file : files) {
 
            try {
 
                String storedName = UUID.randomUUID() + "-" + file.getOriginalFilename();
 
                Path path = Paths.get(UPLOAD_DIR, storedName);
 
                if (!ALLOWED_TYPES.contains(file.getContentType())) {
 
                    throw new FileUploadException("Only images file are allowed");
 
                }
 
                Files.copy(file.getInputStream(), path);
 
                Image image = Image.builder()
                                .originalName(file.getOriginalFilename())
                                .storedName(storedName)
                                .contentType(file.getContentType())
                                .size(file.getSize())
                                .url("/uploads/" + storedName)
                                .uploadedAt(LocalDateTime.now())
                                .project(project)
                                .build();
 
                Image saved = imageRepository.save(image);
 
                responses.add(
                    ImageResponseDTO.builder()
                        .id(saved.getId())
                        .originalName(saved.getOriginalName())
                        .url(saved.getUrl())
                        .build()   
                    
                );
 
            } catch (IOException e) {
 
                throw new RuntimeException(
                    "Upload failed"
                );
 
            }
 
        }
 
        return responses;
 
    }
 
    @Override
    public List<ImageResponseDTO> getByProject (
        Long projectId
    ) {
 
        List<Image> images = imageRepository.findByProjectId(projectId);
 
        return images.stream()
                    .map(image -> ImageResponseDTO.builder()
                                            .id(image.getId())
                                            .originalName(image.getOriginalName())
                                            .url(image.getUrl())
                                            .build()
                    )
                    .toList();
 
    }
 
    @Override
    public void delete (Long imageId) {
 
        Image image = imageRepository.findById(imageId)
                            .orElseThrow(() -> new ResourceNotFoundException(
                                "Image not found"
                            ));
 
        try {
            
            Files.deleteIfExists(Paths.get(
                UPLOAD_DIR,
                image.getStoredName()
            ));
 
        } catch (IOException e) {
            
            throw new RuntimeException(
                "Cannot delete file"
            );
 
        }
 
        imageRepository.delete(image);
 
    }
    
}
 
