package com.hafis.portfolio.service;

import com.hafis.portfolio.dto.request.LoginRequestDTO;
import com.hafis.portfolio.dto.response.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login (LoginRequestDTO requestDTO);
    
}
