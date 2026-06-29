package com.hafis.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hafis.portfolio.entity.About;

public interface AboutRepository extends JpaRepository <About, Long> {

    Optional<About> findFirstBy();
    
}
