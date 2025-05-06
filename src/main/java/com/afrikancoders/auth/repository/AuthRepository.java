package com.afrikancoders.auth.repository;

import com.afrikancoders.auth.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {

    Optional<Auth> findById(Long id);

    Optional<Auth> findByIdAndEmail(Long id, String email);
}
