package com.hafis.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hafis.portfolio.entity.User;

public interface UserRepository extends JpaRepository <User, Long>{

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
    
}
