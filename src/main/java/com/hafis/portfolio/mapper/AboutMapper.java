package com.hafis.portfolio.mapper;

import org.springframework.stereotype.Component;

import com.hafis.portfolio.dto.request.AboutRequestDTO;
import com.hafis.portfolio.dto.response.AboutResponseDTO;
import com.hafis.portfolio.entity.About;

@Component
public class AboutMapper {

    public About toEntity (AboutRequestDTO dto) {

        return About.builder()
                    .fullName(dto.getFullName())
                    .title(dto.getTitle())
                    .description(dto.getDescription())
                    .profileImageUrl(dto.getProfileImageUrl())
                    .build();

    }

    public AboutResponseDTO toResponseDTO (About about) {

        return AboutResponseDTO.builder()
                            .id(about.getId())
                            .fullName(about.getFullName())
                            .title(about.getTitle())
                            .description(about.getDescription())
                            .profileImageUrl(about.getProfileImageUrl())
                            .build();

    }
    
}
