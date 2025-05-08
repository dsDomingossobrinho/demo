package com.afrikancoders.state.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.state.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
    
}
