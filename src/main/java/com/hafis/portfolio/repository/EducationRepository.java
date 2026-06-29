package com.hafis.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafis.portfolio.entity.Education;

public interface EducationRepository extends JpaRepository <Education, Long> {
    
}
