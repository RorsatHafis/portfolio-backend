package com.hafis.portfolio.service.impl;

import org.springframework.stereotype.Service;

import com.hafis.portfolio.dto.request.AboutRequestDTO;
import com.hafis.portfolio.dto.response.AboutResponseDTO;
import com.hafis.portfolio.entity.About;
import com.hafis.portfolio.mapper.AboutMapper;
import com.hafis.portfolio.repository.AboutRepository;
import com.hafis.portfolio.service.AboutService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository repository;
    private final AboutMapper mapper;

    @Override
    public AboutResponseDTO get() {

        About about = repository.findFirstBy()
                                .orElse(About.builder()
                                            .build()
                                );

        return mapper.toResponseDTO(about);

    }
    
    @Override
    public AboutResponseDTO save (AboutRequestDTO requestDTO) {

        About about = repository.findFirstBy()
                                .orElse(new About());

        about.setFullName(requestDTO.getFullName());
        about.setTitle(requestDTO.getTitle());
        about.setDescription(requestDTO.getDescription());
        about.setProfileImageUrl(requestDTO.getProfileImageUrl());

        About saved = repository.save(about);

        return mapper.toResponseDTO(saved);

    }

}
