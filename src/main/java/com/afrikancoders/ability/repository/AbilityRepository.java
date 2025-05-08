package com.afrikancoders.ability.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.ability.entity.Abilitys;

public interface AbilityRepository extends JpaRepository<Abilitys, Long> {
    
}
