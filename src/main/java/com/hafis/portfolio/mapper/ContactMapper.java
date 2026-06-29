package com.hafis.portfolio.mapper;

import org.springframework.stereotype.Component;

import com.hafis.portfolio.dto.request.ContactRequestDTO;
import com.hafis.portfolio.dto.response.ContactResponseDTO;
import com.hafis.portfolio.entity.Contact;

@Component
public class ContactMapper {

    public Contact toEntity(ContactRequestDTO requestDTO) {

        return Contact.builder()
                    .email(requestDTO.getEmail())
                    .phone(requestDTO.getPhone())
                    .github(requestDTO.getGithub())
                    .linkedin(requestDTO.getLinkedin())
                    .facebook(requestDTO.getFacebook())
                    .telegram(requestDTO.getTelegram())
                    .build();

    }
    
    public ContactResponseDTO toResponseDTO (Contact contact) {

        return ContactResponseDTO.builder()
                    .id(contact.getId())
                    .email(contact.getEmail())
                    .phone(contact.getPhone())
                    .github(contact.getGithub())
                    .linkedin(contact.getLinkedin())
                    .facebook(contact.getFacebook())
                    .telegram(contact.getTelegram())
                    .build();

    }

}
