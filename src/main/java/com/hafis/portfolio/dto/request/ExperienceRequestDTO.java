package com.hafis.portfolio.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
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
public class ExperienceRequestDTO {

    @NotBlank
    private String company;

    @NotBlank
    private String position;

    private LocalDate startDate;

    private LocalDate endDate;

    @NotBlank
    private String description;

    private String companyLogoUrl;
    
}
