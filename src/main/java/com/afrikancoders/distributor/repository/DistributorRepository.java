package com.afrikancoders.distributor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.distributor.entity.Distributors;

public interface DistributorRepository extends JpaRepository<Distributors, Long> {
    
}
