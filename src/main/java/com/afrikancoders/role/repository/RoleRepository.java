package com.afrikancoders.role.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.afrikancoders.role.entity.Roles;
import com.afrikancoders.role.response.RoleResponse;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findById(Long id);

    Optional<Roles> findByRole(String role);

    Optional<Roles> findByIdAndStateId(Long id, Long stateId);

    Optional<Roles> findByRoleAndStateId(String Role, Long stateId);

    List<Roles> findAll();

    @Query("SELECT new com.afrikancoders.role.response.RoleResponse(r.id, r.role) FROM Roles r WHERE r.state.id = 1")
    List<RoleResponse> findAllResponse();
}
