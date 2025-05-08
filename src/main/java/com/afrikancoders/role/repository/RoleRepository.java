package com.afrikancoders.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.role.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    
}
