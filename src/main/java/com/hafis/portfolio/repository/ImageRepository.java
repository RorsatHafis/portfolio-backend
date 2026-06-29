package com.hafis.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafis.portfolio.entity.Image;

public interface ImageRepository extends JpaRepository <Image, Long> {

    List<Image> findByProjectId (Long projectId);
    
}
