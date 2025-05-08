package com.afrikancoders.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.evaluation.entity.Evaluations;

public interface EvaluationRepository extends JpaRepository<Evaluations, Long> {
    
}
