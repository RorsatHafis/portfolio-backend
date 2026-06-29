package com.hafis.portfolio.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactRequestDTO {

    @Email
    @NotBlank
    private String email;

    private String phone;

    private String github;

    private String linkedin;

    private String facebook;

    private String telegram;
    
}
