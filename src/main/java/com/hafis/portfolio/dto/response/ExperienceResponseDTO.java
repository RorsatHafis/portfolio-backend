package com.hafis.portfolio.dto.response;

import java.time.LocalDate;

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
public class ExperienceResponseDTO {

    private Long id;

    private String company;

    private String position;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private String companyLogoUrl;
    
}
