package com.hafis.portfolio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hafis.portfolio.dto.request.ExperienceRequestDTO;
import com.hafis.portfolio.dto.response.ExperienceResponseDTO;
import com.hafis.portfolio.entity.Experience;
import com.hafis.portfolio.exception.ResourceNotFoundException;
import com.hafis.portfolio.mapper.ExperienceMapper;
import com.hafis.portfolio.repository.ExperienceRepository;
import com.hafis.portfolio.service.ExperienceService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository repository;
    private final ExperienceMapper mapper;

    @Override
    public List<ExperienceResponseDTO> getAlls () {

        return repository.findAll()
                        .stream()
                        .map(mapper::toResponseDTO)
                        .toList();

    }

    @Override
    public ExperienceResponseDTO getById (Long id) {

        Experience experience = repository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                            "Experience not found with id: " + id
                                        ));

        return mapper.toResponseDTO(experience);

    }

    @Override
    public ExperienceResponseDTO create (ExperienceRequestDTO requestDTO) {

        Experience experience = mapper.toEntity(requestDTO);

        Experience saved = repository.save(experience);

        return mapper.toResponseDTO(saved);

    }

    @Override
    public ExperienceResponseDTO update (Long id, ExperienceRequestDTO requestDTO) {

        Experience experience = repository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                            "Experience not found with id: " + id
                                        ));

        experience.setCompany(requestDTO.getCompany());
        experience.setPosition(requestDTO.getPosition());
        experience.setStartDate(requestDTO.getStartDate());
        experience.setEndDate(requestDTO.getEndDate());
        experience.setDescription(requestDTO.getDescription());
        experience.setCompanyLogoUrl(requestDTO.getCompanyLogoUrl());

        Experience updated = repository.save(experience);

        return mapper.toResponseDTO(updated);

    }

    @Override
    public void delete (Long id) {

        Experience experience = repository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                            "Experience not found with id: " + id
                                        ));

        repository.delete(experience);

    }
     
}
