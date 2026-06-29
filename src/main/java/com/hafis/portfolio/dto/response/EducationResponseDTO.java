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
public class EducationResponseDTO {

    private Long id;

    private String school;

    private String degree;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private String logoUrl;
    
}
