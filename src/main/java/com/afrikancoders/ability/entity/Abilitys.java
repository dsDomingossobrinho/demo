package com.afrikancoders.ability.entity;

import com.afrikancoders.model.AbstractModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Abilitys extends AbstractModel{

    @Column(nullable = false)
    @NotBlank(message = "Enter a Ability")
    private String ability;
    
}
