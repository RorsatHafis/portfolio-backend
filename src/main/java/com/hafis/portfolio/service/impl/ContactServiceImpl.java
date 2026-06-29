package com.hafis.portfolio.service.impl;

import org.springframework.stereotype.Service;

import com.hafis.portfolio.dto.request.ContactRequestDTO;
import com.hafis.portfolio.dto.response.ContactResponseDTO;
import com.hafis.portfolio.entity.Contact;
import com.hafis.portfolio.mapper.ContactMapper;
import com.hafis.portfolio.repository.ContactRepository;
import com.hafis.portfolio.service.ContactService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repository;
    private final ContactMapper mapper;

    @Override
    public ContactResponseDTO get() {

        Contact contact = repository.findFirstBy()
                                .orElse(Contact.builder()
                                            .build()
                                );

        return mapper.toResponseDTO(contact);

    }
    
    @Override
    public ContactResponseDTO save (ContactRequestDTO requestDTO) {

        Contact contact = repository.findFirstBy()
                                .orElse(new Contact());

        contact.setEmail(requestDTO.getEmail());
        contact.setPhone(requestDTO.getPhone());
        contact.setGithub(requestDTO.getGithub());
        contact.setLinkedin(requestDTO.getLinkedin());
        contact.setFacebook(requestDTO.getFacebook());
        contact.setTelegram(requestDTO.getTelegram());

        Contact saved = repository.save(contact);

        return mapper.toResponseDTO(saved);
    
    }
    
}
