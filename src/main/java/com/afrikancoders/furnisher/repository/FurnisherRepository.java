package com.afrikancoders.furnisher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.furnisher.entity.Furnishers;

public interface FurnisherRepository extends JpaRepository<Furnishers, Long> {
    
}
