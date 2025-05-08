package com.afrikancoders.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.company.entity.Companys;

public interface CompanyRepository extends JpaRepository<Companys, Long> {
    
}
