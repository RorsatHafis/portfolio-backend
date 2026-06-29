package com.hafis.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafis.portfolio.entity.Project;

public interface ProjectRepository extends JpaRepository <Project, Long>{
    
}
