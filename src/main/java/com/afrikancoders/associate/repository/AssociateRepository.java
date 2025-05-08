package com.afrikancoders.associate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.associate.entity.Associates;

public interface AssociateRepository extends JpaRepository<Associates, Long> {

    
}
