package com.hafis.portfolio.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.hafis.portfolio.dto.request.ProjectRequestDTO;
import com.hafis.portfolio.dto.response.ProjectResponseDTO;
import com.hafis.portfolio.entity.Image;
import com.hafis.portfolio.entity.Project;
import com.hafis.portfolio.entity.Skill;
import com.hafis.portfolio.exception.ResourceNotFoundException;
import com.hafis.portfolio.mapper.ProjectMapper;
import com.hafis.portfolio.repository.ImageRepository;
import com.hafis.portfolio.repository.ProjectRepository;
import com.hafis.portfolio.repository.SkillRepository;
import com.hafis.portfolio.service.ProjectService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final ImageRepository imageRepository;
    private final ProjectMapper mapper;

    @Override
    public List<ProjectResponseDTO> getAlls () {

        return projectRepository.findAll()
                                .stream()
                                .map(mapper::toResponseDTO)
                                .toList();

    }

    @Override
    public ProjectResponseDTO getById (Long id) {

        Project project = projectRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                    "Project not found with id: " + id
                                ));

        return mapper.toResponseDTO(project);

    }

    @Override
    public ProjectResponseDTO create (ProjectRequestDTO requestDTO) {

        List<Skill> skills = getSkills(requestDTO.getSkillIds());
        List<Image> images = getImages(requestDTO.getImageIds());

        Project project = Project.builder()
                            .title(requestDTO.getTitle())
                            .description(requestDTO.getDescription())
                            .githubUrl(requestDTO.getGithubUrl())
                            .liveUrl(requestDTO.getLiveUrl())
                            .featured(requestDTO.getFeatured())
                            .skills(skills)
                            .images(images)
                            .build();

        for (Image image : images) {

            image.setProject(project);

        }

        Project saved = projectRepository.save(project);

        return mapper.toResponseDTO(saved);

    }

    @Override
    public ProjectResponseDTO update (Long id, ProjectRequestDTO requestDTO) {

        Project project = projectRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                    "Project not found with id: " + id
                                ));

        List<Skill> skills = getSkills(requestDTO.getSkillIds());
        List<Image> images = getImages(requestDTO.getImageIds());

        project.setTitle(requestDTO.getTitle());
        project.setDescription(requestDTO.getDescription());
        project.setGithubUrl(requestDTO.getGithubUrl());
        project.setLiveUrl(requestDTO.getLiveUrl());
        project.setFeatured(requestDTO.getFeatured());
        project.setSkills(skills);
        project.setImages(images);

        for (Image image : images) {

            image.setProject(project);

        }

        Project updated = projectRepository.save(project);

        return mapper.toResponseDTO(updated);

    }

    @Override
    public void delete (Long id) {

        Project project = projectRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                    "Project not found with id: " + id
                                ));

        projectRepository.delete(project);

    }

    private List<Skill> getSkills (List<Long> skillIds) {

        List<Skill> skills = skillRepository.findAllById(skillIds);

        if (skills.size() != skillIds.size()) {

            throw new ResourceNotFoundException(
                "One or more skills not found!"
            );

        }

        return skills;

    }

    private List<Image> getImages (List<Long> imageIds) {

        List<Image> images = imageRepository.findAllById(imageIds);

        if (images.size() != imageIds.size()) {

            throw new ResourceNotFoundException(
                "One or more images not found!"
            );

        }

        return images;

    }

 
}
