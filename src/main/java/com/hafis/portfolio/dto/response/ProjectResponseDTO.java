package com.hafis.portfolio.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponseDTO {

    private Long id;

    private String title;

    private String description;

    private String githubUrl;

    private String liveUrl;

    private Boolean featured;

    private List<SkillResponseDTO> skills;

    private List<ImageResponseDTO> images;

}