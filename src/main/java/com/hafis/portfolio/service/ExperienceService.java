package com.hafis.portfolio.service;

import java.util.List;

import com.hafis.portfolio.dto.request.ExperienceRequestDTO;
import com.hafis.portfolio.dto.response.ExperienceResponseDTO;

public interface ExperienceService {

    List<ExperienceResponseDTO> getAlls ();

    ExperienceResponseDTO getById (Long id);

    ExperienceResponseDTO create (ExperienceRequestDTO requestDTO);

    ExperienceResponseDTO update (Long id, ExperienceRequestDTO requestDTO);

    void delete (Long id);
    
}
