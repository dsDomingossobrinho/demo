package com.afrikancoders.collaborator.entity;

import com.afrikancoders.model.Users;
import com.afrikancoders.userIdentificator.entity.UserIdentificators;
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
    @JoinColumn(name = "user_identificator_id")
    @JsonIgnoreProperties("collaborators")
    private UserIdentificators userIdentificator;
    
}
