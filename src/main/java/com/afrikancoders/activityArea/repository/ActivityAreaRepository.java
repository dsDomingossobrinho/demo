package com.afrikancoders.activityArea.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afrikancoders.activityArea.entity.ActivityAreas;
import com.afrikancoders.activityArea.response.ActivityAreaResponse;

public interface ActivityAreaRepository extends JpaRepository<ActivityAreas, Long> {
    Optional<ActivityAreas> findById(Long id);

    Optional<ActivityAreas> findByActivityArea(String activityArea);

    Optional<ActivityAreas> findByIdAndStateId(Long id, Long stateId);

    Optional<ActivityAreas> findByActivityAreaAndStateId(String activityArea, Long stateId);

    List<ActivityAreas> findAll();

    @Query("SELECT new com.afrikancoders.activityArea.response.ActivityAreaResponse(a.id, a.activityArea) FROM ActivityAreas a WHERE a.state.id = 1")
    List<ActivityAreaResponse> findAllResponse();
    
}
