package com.afrikancoders.collaboratorAbility.entity;

import com.afrikancoders.ability.entity.Abilitys;
import com.afrikancoders.collaborator.entity.Collaborators;
import com.afrikancoders.model.AbstractModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class CollaboratorAbilitys extends AbstractModel{

    @ManyToOne
    @JoinColumn(name = "ability_id")
    @JsonIgnoreProperties("collaboratorAbilitys")
    private Abilitys ability;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    @JsonIgnoreProperties("collaboratorAbilitys")
    private Collaborators collaborator;
    
}
