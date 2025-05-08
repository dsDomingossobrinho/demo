package com.afrikancoders.collaborator.entity;

import com.afrikancoders.distributor.entity.Distributors;
import com.afrikancoders.furnisher.entity.Furnishers;
import com.afrikancoders.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;
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
public class Collaborators extends Users {

    @Column(nullable = false)
    private Float hour_price;

    @ManyToOne
    @JoinColumn(name = "furnisher_id")
    @JsonIgnoreProperties("collaborators")
    private Furnishers furnisher;

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    @JsonIgnoreProperties("collaborators")
    private Distributors distributor;
    
}
