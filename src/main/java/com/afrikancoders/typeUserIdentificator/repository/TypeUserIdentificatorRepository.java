package com.afrikancoders.typeUserIdentificator.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afrikancoders.typeUserIdentificator.entity.TypeUserIdentificators;
import com.afrikancoders.typeUserIdentificator.response.TypeUserIdentificatorResponse;

public interface TypeUserIdentificatorRepository extends JpaRepository<TypeUserIdentificators, Long> {

    Optional<TypeUserIdentificators> findById(Long id);

    Optional<TypeUserIdentificators> findByType(String TypeUserIdentificator);

    Optional<TypeUserIdentificators> findByIdAndStateId(Long id, Long stateId);

    Optional<TypeUserIdentificators> findByTypeAndStateId(String Type, Long stateId);

    List<TypeUserIdentificators> findAll();

    @Query("SELECT new com.afrikancoders.typeUserIdentificator.response.TypeUserIdentificatorResponse(t.id, t.type) FROM TypeUserIdentificators t WHERE t.state.id = 1")
    List<TypeUserIdentificatorResponse> findAllResponse();
    
}
