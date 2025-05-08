package com.afrikancoders.typeUserIdentificator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.typeUserIdentificator.entity.TypeUserIdentificators;

public interface TypeUserIdentificatorRepository extends JpaRepository<TypeUserIdentificators, Long> {
    
}
