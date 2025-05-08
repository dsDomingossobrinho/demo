package com.afrikancoders.evaluationCriteria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.afrikancoders.evaluationCriteria.entity.EvaluationCriterias;

public interface EvaluationCriteriaRepository extends JpaRepository<EvaluationCriterias, Long> {
    
}
