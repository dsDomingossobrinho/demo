package com.afrikancoders.collaborator.entity;

import org.springframework.boot.autoconfigure.rsocket.RSocketProperties.Server.Spec;

import com.afrikancoders.ability.entity.Abilitys;
import com.afrikancoders.activityArea.entity.ActivityAreas;
import com.afrikancoders.distributor.entity.Distributors;
import com.afrikancoders.furnisher.entity.Furnishers;
import com.afrikancoders.model.Users;
import com.afrikancoders.specialty.entity.Specialitys;
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
