package com.afrikancoders.counting.entity;

import java.time.LocalDateTime;

import com.afrikancoders.collaborator.entity.Collaborators;
import com.afrikancoders.company.entity.Companys;
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
public class Countings extends AbstractModel {
    

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("countings")
    private Companys company;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    @JsonIgnoreProperties("countings")
    private Collaborators collaborator;

    @Column(nullable = true)
    private LocalDateTime start_date;

    @Column(nullable = true)
    private LocalDateTime finish_date;
}
