package com.afrikancoders.ability.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afrikancoders.ability.entity.Abilitys;
import com.afrikancoders.ability.response.AbilityResponse;

public interface AbilityRepository extends JpaRepository<Abilitys, Long> {

    Optional<Abilitys> findById(Long id);

    Optional<Abilitys> findByAbility(String ability);

    Optional<Abilitys> findByIdAndStateId(Long id, Long stateId);

    Optional<Abilitys> findByAbilityAndStateId(String ability, Long stateId);

    List<Abilitys> findAll();

    @Query("SELECT new com.afrikancoders.ability.response.AbilityResponse(a.id, a.ability) FROM Abilitys a WHERE a.state_id = 1")
    List<AbilityResponse> findAllResponse();
    
}
