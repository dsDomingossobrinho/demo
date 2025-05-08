package com.afrikancoders.userIdentificator.entity;

import com.afrikancoders.model.AbstractModel;
import com.afrikancoders.typeUserIdentificator.entity.TypeUserIdentificators;
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
public class UserIdentificators extends AbstractModel{

    @Column(nullable = false)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "type_userIdentificator_id")
    @JsonIgnoreProperties("userIdentificators")
    private TypeUserIdentificators typeUserIdentificator;
    
}
