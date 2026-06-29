package com.hafis.portfolio.dto.request;

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
public class AboutRequestDTO {

    @NotBlank
    private String fullName;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private String profileImageUrl;
    
}
