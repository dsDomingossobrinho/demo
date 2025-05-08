package com.afrikancoders.evaluationCriteria.entity;

import java.time.LocalDateTime;

import com.afrikancoders.collaborator.entity.Collaborators;
import com.afrikancoders.company.entity.Companys;
import com.afrikancoders.distributor.entity.Distributors;
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
public class EvaluationCriterias extends AbstractModel {
    
    
    @Column(nullable = false)
    private Float value;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("evaluationCriterias")
    private Companys company;
}
