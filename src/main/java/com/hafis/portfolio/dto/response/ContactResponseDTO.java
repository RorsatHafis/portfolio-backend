package com.hafis.portfolio.dto.response;

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
public class ContactResponseDTO {

    private Long id;

    private String email;

    private String phone;

    private String github;

    private String linkedin;

    private String facebook;

    private String telegram;
    
}
