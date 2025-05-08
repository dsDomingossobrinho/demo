package com.afrikancoders.specialty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.specialty.entity.Specialitys;

public interface SpecialityRepository extends JpaRepository<Specialitys, Long> {
    
}
