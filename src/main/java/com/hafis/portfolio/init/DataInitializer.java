package com.hafis.portfolio.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hafis.portfolio.entity.Role;
import com.hafis.portfolio.entity.User;
import com.hafis.portfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(
                                    DataInitializer.class
                                );

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Value("${app.admin.username:admin}")
    private String adminUsername;

    @Value("${app.admin.password:admin123}")
    private String adminPassword;

    @Override
    public void run (String... args) {

        if (adminUsername.isBlank() || adminPassword.isBlank()) {

            logger.info("Admin credentials not provided. Skipping admin initialization.");
            return;

        }


        if (repository.findByUsername(adminUsername).isPresent()) {

            logger.info("Admin user already exists.");
            return;

        }

        User admin = User.builder()
                        .username(adminUsername)
                        .password(passwordEncoder.encode(adminPassword))
                        .role(Role.ADMIN)
                        .build();

        repository.save(admin);

        logger.info("Default admin '{}' created successfully.", adminUsername);

    }
    
}
