package com.hafis.portfolio.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private String githubUrl;

    private String liveUrl;

    @NotNull
    private Boolean featured;

    @Builder.Default
    private List<Long> skillIds = new ArrayList<>();

    @Builder.Default
    private List<Long> imageIds = new ArrayList<>();

}