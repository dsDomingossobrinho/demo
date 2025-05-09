package com.afrikancoders.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}
