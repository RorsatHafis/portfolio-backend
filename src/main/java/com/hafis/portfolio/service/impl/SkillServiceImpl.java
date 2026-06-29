package com.hafis.portfolio.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hafis.portfolio.dto.request.SkillRequestDTO;
import com.hafis.portfolio.dto.response.SkillResponseDTO;
import com.hafis.portfolio.entity.Skill;
import com.hafis.portfolio.exception.ResourceNotFoundException;
import com.hafis.portfolio.mapper.SkillMapper;
import com.hafis.portfolio.repository.SkillRepository;
import com.hafis.portfolio.service.SkillService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService{

    private final SkillRepository repository;
    private final SkillMapper mapper;

    @Override
    public List<SkillResponseDTO> getAlls () {

        return repository.findAll()
                        .stream()
                        .map(mapper::toResponseDTO)
                        .toList();

    }

    @Override
    public SkillResponseDTO getById (Long id) {

        Skill skill = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                            "Skill not found with id: " + id
                        ));

        return mapper.toResponseDTO(skill);

    }

    @Override
    public SkillResponseDTO create (SkillRequestDTO requestDTO) {

        Skill skill = mapper.toEntity(requestDTO);

        Skill saved = repository.save(skill);

        return mapper.toResponseDTO(saved);

    }

    @Override
    public SkillResponseDTO update (Long id, SkillRequestDTO requestDTO) {

        Skill skill = repository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                    "Skill not found with id: " + id
                                ));

        skill.setName(requestDTO.getName());
        skill.setCategory(requestDTO.getCategory());
        skill.setLevel(requestDTO.getLevel());

        Skill updated = repository.save(skill);

        return mapper.toResponseDTO(updated);

    } 

    @Override
    public void delete (Long id) {

        Skill skill = repository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException(
                                    "Skill not found with id: " + id
                                ));

        repository.delete(skill);

    }
    
}
