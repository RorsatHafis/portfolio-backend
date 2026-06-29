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
public class AboutResponseDTO {

    private Long id;

    private String fullName;

    private String title;

    private String description;

    private String profileImageUrl;
    
}
