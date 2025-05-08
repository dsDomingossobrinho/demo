package com.afrikancoders.counting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.counting.entity.Countings;

public interface CountingRepository extends JpaRepository<Countings, Long> {
    
}
