package com.hafis.portfolio.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hafis.portfolio.dto.response.ImageResponseDTO;
import com.hafis.portfolio.dto.response.ProjectResponseDTO;
import com.hafis.portfolio.dto.response.SkillResponseDTO;
import com.hafis.portfolio.entity.Image;
import com.hafis.portfolio.entity.Project;
import com.hafis.portfolio.entity.Skill;

@Component
public class ProjectMapper {

    public ProjectResponseDTO toResponseDTO (Project project) {

        List<SkillResponseDTO> skills = project.getSkills()
                                            .stream()
                                            .map(this::mapSkill)
                                            .toList();


        List<ImageResponseDTO> images = project.getImages()
                                            .stream()
                                            .map(this::mapImage)
                                            .toList();


        return ProjectResponseDTO.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .githubUrl(project.getGithubUrl())
                .liveUrl(project.getLiveUrl())
                .featured(project.getFeatured())
                .skills(skills)
                .images(images)
                .build();

    }

    private SkillResponseDTO mapSkill (Skill skill) {

        return SkillResponseDTO.builder()
                .id(skill.getId())
                .name(skill.getName())
                .category(skill.getCategory())
                .level(skill.getLevel())
                .build();

    }

    private ImageResponseDTO mapImage (Image image) {

        return ImageResponseDTO.builder()
                .id(image.getId())
                .originalName(image.getOriginalName())
                .url( image.getUrl())
                .build();

    }
    
}
