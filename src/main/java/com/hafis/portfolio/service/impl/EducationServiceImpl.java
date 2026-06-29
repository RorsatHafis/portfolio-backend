package com.hafis.portfolio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hafis.portfolio.dto.request.EducationRequestDTO;
import com.hafis.portfolio.dto.response.EducationResponseDTO;
import com.hafis.portfolio.entity.Education;
import com.hafis.portfolio.exception.ResourceNotFoundException;
import com.hafis.portfolio.mapper.EducationMapper;
import com.hafis.portfolio.repository.EducationRepository;
import com.hafis.portfolio.service.EducationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository repository;
    private final EducationMapper mapper;

    @Override
    public List<EducationResponseDTO> getAlls () {

        return repository.findAll()
                        .stream()
                        .map(mapper::toResponseDTO)
                        .toList();

    }

    @Override
    public EducationResponseDTO getById (Long id) {

        Education education = repository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException(
                                        "Education not found with id: " + id
                                    ));

        return mapper.toResponseDTO(education);

    }

    @Override
    public EducationResponseDTO create (EducationRequestDTO requestDTO) {

        Education education = mapper.toEntity(requestDTO);

        Education saved = repository.save(education);

        return mapper.toResponseDTO(saved);

    }

    @Override
    public EducationResponseDTO update (Long id, EducationRequestDTO requestDTO) {

        Education education = repository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException(
                                        "Education not found with id: " + id
                                    ));
                                    
        education.setSchool(requestDTO.getSchool());
        education.setDegree(requestDTO.getDegree());
        education.setStartDate(requestDTO.getStartDate());
        education.setEndDate(requestDTO.getEndDate());
        education.setDescription(requestDTO.getDescription());
        education.setLogoUrl(requestDTO.getLogoUrl());

        Education saved = repository.save(education);

        return mapper.toResponseDTO(saved);

    }

    @Override
    public void delete (Long id) {

        Education education = repository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException(
                                        "Education not found with id: " + id
                                    ));

        repository.delete(education);

    }
    
}
