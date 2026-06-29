package com.hafis.portfolio.mapper;

import org.springframework.stereotype.Component;

import com.hafis.portfolio.dto.request.EducationRequestDTO;
import com.hafis.portfolio.dto.response.EducationResponseDTO;
import com.hafis.portfolio.entity.Education;

@Component
public class EducationMapper {

    public Education toEntity (EducationRequestDTO requestDTO) {

        return Education.builder()
                        .school(requestDTO.getSchool())
                        .degree(requestDTO.getDegree())
                        .startDate(requestDTO.getStartDate())
                        .endDate(requestDTO.getEndDate())
                        .description(requestDTO.getDescription())
                        .logoUrl(requestDTO.getLogoUrl())
                        .build();

    }

    public EducationResponseDTO toResponseDTO (Education education) {

        return EducationResponseDTO.builder()
                        .id(education.getId())
                        .school(education.getSchool())
                        .degree(education.getDegree())
                        .startDate(education.getStartDate())
                        .endDate(education.getEndDate())
                        .description(education.getDescription())
                        .logoUrl(education.getLogoUrl())
                        .build();

    }
    
}
