package com.hafis.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafis.portfolio.entity.Contact;

public interface ContactRepository extends JpaRepository <Contact, Long> {

    Optional<Contact> findFirstBy();
    
}
