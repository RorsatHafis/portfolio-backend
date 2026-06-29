package com.hafis.portfolio.service;

import com.hafis.portfolio.dto.request.AboutRequestDTO;
import com.hafis.portfolio.dto.response.AboutResponseDTO;

public interface AboutService {

    AboutResponseDTO get();

    AboutResponseDTO save (AboutRequestDTO requestDTO);
    
}
