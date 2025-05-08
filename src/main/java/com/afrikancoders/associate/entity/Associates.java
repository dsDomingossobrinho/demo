package com.afrikancoders.associate.entity;

import java.time.LocalDateTime;

import com.afrikancoders.collaborator.entity.Collaborators;
import com.afrikancoders.distributor.entity.Distributors;
import com.afrikancoders.model.AbstractModel;
import com.afrikancoders.state.entity.Status;
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
public class Associates extends AbstractModel{

    @Column(nullable = false)
    private Float hour_price;

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    @JsonIgnoreProperties("associates")
    private Distributors distributor;

    @ManyToOne
    @JoinColumn(name = "collaborat_id")
    @JsonIgnoreProperties("associates")
    private Collaborators collaborator;

    @Column(nullable = true)
    private LocalDateTime start_date;

    @Column(nullable = true)
    private LocalDateTime finish_date;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnoreProperties("associates")
    private Status state;
    
}
