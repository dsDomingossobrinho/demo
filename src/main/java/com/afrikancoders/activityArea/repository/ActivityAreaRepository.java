package com.afrikancoders.activityArea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.activityArea.entity.ActivityAreas;

public interface ActivityAreaRepository extends JpaRepository<ActivityAreas, Long> {
    
}
