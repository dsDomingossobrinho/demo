package com.afrikancoders.state.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afrikancoders.state.entity.Status;
import com.afrikancoders.state.response.StateResponse;

public interface StatusRepository extends JpaRepository<Status, Long> {

    Optional<Status> findById(Long id);

    Optional<Status> findByState(String state);

    List<Status> findAll();

    @Query("SELECT new com.afrikancoders.state.response.StateResponse(s.id, s.state) FROM Status s")
    List<StateResponse> findAllResponse();
    
}
