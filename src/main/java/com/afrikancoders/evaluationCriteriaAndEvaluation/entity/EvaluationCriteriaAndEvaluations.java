package com.afrikancoders.evaluationCriteriaAndEvaluation.entity;

import com.afrikancoders.evaluationCriteria.entity.EvaluationCriterias;
import com.afrikancoders.evaluation.entity.Evaluations;
import com.afrikancoders.model.AbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class EvaluationCriteriaAndEvaluations extends AbstractModel {

    @Column(nullable = false)
    private Float value;

    @ManyToOne
    @JoinColumn(name = "evaluation_id")
    @JsonIgnoreProperties("evaluationCriteriaAndEvaluations")
    private Evaluations evaluation;

    @ManyToOne
    @JoinColumn(name = "evaluation_criteria_id")
    @JsonIgnoreProperties("evaluationCriteriaAndEvaluations")
    private EvaluationCriterias evaluationCriteria;
    
}
