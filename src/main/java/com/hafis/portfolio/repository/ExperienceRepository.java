package com.hafis.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafis.portfolio.entity.Experience;

public interface ExperienceRepository extends JpaRepository <Experience, Long> {
    
}
