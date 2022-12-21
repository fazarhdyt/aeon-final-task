package com.aeon.models.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeon.models.entities.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    
    Optional<AppUser> findByEmail(String email);
}
