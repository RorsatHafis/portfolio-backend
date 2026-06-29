package com.hafis.portfolio.service;

import java.util.List;

import com.hafis.portfolio.dto.request.SkillRequestDTO;
import com.hafis.portfolio.dto.response.SkillResponseDTO;

public interface SkillService {

    List<SkillResponseDTO> getAlls ();

    SkillResponseDTO getById (Long id);

    SkillResponseDTO create (SkillRequestDTO requestDTO);

    SkillResponseDTO update (Long id, SkillRequestDTO requestDTO);

    void delete (Long id);
    
}
