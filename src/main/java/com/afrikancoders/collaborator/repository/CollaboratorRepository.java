package com.afrikancoders.collaborator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.collaborator.entity.Collaborators;

public interface CollaboratorRepository extends JpaRepository<Collaborators, Long> {
    
}
