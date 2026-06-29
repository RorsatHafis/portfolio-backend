package com.hafis.portfolio.service;

import java.util.List;

import com.hafis.portfolio.dto.request.ProjectRequestDTO;
import com.hafis.portfolio.dto.response.ProjectResponseDTO;

public interface ProjectService {

    List<ProjectResponseDTO> getAlls ();

    ProjectResponseDTO getById (Long id);

    ProjectResponseDTO create (ProjectRequestDTO requestDTO);

    ProjectResponseDTO update (Long id, ProjectRequestDTO requestDTO);

    void delete (Long id);

}
