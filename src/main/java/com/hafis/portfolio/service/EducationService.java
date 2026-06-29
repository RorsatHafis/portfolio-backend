package com.hafis.portfolio.service;

import java.util.List;

import com.hafis.portfolio.dto.request.EducationRequestDTO;
import com.hafis.portfolio.dto.response.EducationResponseDTO;

public interface EducationService {

    List<EducationResponseDTO> getAlls ();

    EducationResponseDTO getById (Long id);

    EducationResponseDTO create (EducationRequestDTO requestDTO);

    EducationResponseDTO update (Long id, EducationRequestDTO requestDTO);

    void delete (Long id);
    
}
