package com.hafis.portfolio.service;

import com.hafis.portfolio.dto.request.ContactRequestDTO;
import com.hafis.portfolio.dto.response.ContactResponseDTO;

public interface ContactService {

    ContactResponseDTO get();

    ContactResponseDTO save(ContactRequestDTO requestDTO);
    
}
