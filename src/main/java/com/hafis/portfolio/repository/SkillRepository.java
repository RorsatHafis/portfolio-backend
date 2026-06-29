package com.hafis.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafis.portfolio.entity.Skill;

public interface SkillRepository extends JpaRepository <Skill, Long> {
    
}
