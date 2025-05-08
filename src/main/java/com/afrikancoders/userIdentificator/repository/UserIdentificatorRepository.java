package com.afrikancoders.userIdentificator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.userIdentificator.entity.UserIdentificators;

public interface UserIdentificatorRepository extends JpaRepository<UserIdentificators, Long> {
    
}
