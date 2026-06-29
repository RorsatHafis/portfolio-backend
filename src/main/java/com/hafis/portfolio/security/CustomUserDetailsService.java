package com.hafis.portfolio.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.hafis.portfolio.entity.User;
import com.hafis.portfolio.exception.UserNotFoundException;
import com.hafis.portfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername (String username) throws UserNotFoundException {

        User user = repository.findByUsername(username)
                            .orElseThrow(() -> new UserNotFoundException(
                                "User not found"
                            ));

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            List.of(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
            )
        );

    }
    
}
