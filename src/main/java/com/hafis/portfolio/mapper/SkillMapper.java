package com.hafis.portfolio.mapper;

import org.springframework.stereotype.Component;

import com.hafis.portfolio.dto.request.SkillRequestDTO;
import com.hafis.portfolio.dto.response.SkillResponseDTO;
import com.hafis.portfolio.entity.Skill;

@Component
public class SkillMapper {

    public Skill toEntity (SkillRequestDTO requestDTO) {

        return Skill.builder()
                    .name(requestDTO.getName())
                    .category(requestDTO.getCategory())
                    .level(requestDTO.getLevel())
                    .build();

    }

    public SkillResponseDTO toResponseDTO (Skill skill){

        return SkillResponseDTO.builder()
                    .id(skill.getId())
                    .name(skill.getName())
                    .category(skill.getCategory())
                    .level(skill.getLevel())
                    .build();

    }
    
}
