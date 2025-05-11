package com.afrikancoders.collaboratorSpeciality.entity;

import com.afrikancoders.collaborator.entity.Collaborators;
import com.afrikancoders.model.AbstractModel;
import com.afrikancoders.speciality.entity.Specialitys;
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
public class CollaboratorSpecialitys extends AbstractModel{

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    @JsonIgnoreProperties("CollaboratorSpecialitys")
    private Specialitys speciality;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    @JsonIgnoreProperties("CollaboratorSpecialitys")
    private Collaborators collaborator;
    
}
