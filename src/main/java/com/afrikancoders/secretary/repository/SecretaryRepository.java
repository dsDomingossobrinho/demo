package com.afrikancoders.secretary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.secretary.entity.Secretarys;

public interface SecretaryRepository extends JpaRepository<Secretarys, Long> {
    
}
