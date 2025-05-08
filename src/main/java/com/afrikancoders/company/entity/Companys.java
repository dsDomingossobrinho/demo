package com.afrikancoders.company.entity;

import com.afrikancoders.distributor.entity.Distributors;
import com.afrikancoders.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Companys extends Users {

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    @JsonIgnoreProperties("companys")
    private Distributors distributor;
    
}
