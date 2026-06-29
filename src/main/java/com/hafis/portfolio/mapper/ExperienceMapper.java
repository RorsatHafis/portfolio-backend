package com.hafis.portfolio.mapper;

import org.springframework.stereotype.Component;

import com.hafis.portfolio.dto.request.ExperienceRequestDTO;
import com.hafis.portfolio.dto.response.ExperienceResponseDTO;
import com.hafis.portfolio.entity.Experience;

@Component
public class ExperienceMapper {

    public Experience toEntity (ExperienceRequestDTO requestDTO) {

        return Experience.builder()
                        .company(requestDTO.getCompany())
                        .position(requestDTO.getPosition())
                        .startDate(requestDTO.getStartDate())
                        .endDate(requestDTO.getEndDate())
                        .description(requestDTO.getDescription())
                        .companyLogoUrl(requestDTO.getCompanyLogoUrl())
                        .build();

    }

    public ExperienceResponseDTO toResponseDTO (Experience experience) {

        return ExperienceResponseDTO.builder()
                        .id(experience.getId())
                        .company(experience.getCompany())
                        .position(experience.getPosition())
                        .startDate(experience.getStartDate())
                        .endDate(experience.getEndDate())
                        .description(experience.getDescription())
                        .companyLogoUrl(experience.getCompanyLogoUrl())
                        .build();

    }
    
}
