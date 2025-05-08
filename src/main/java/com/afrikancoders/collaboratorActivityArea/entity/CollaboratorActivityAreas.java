package com.afrikancoders.collaboratorActivityArea.entity;

import com.afrikancoders.activityArea.entity.ActivityAreas;
import com.afrikancoders.collaborator.entity.Collaborators;
import com.afrikancoders.model.AbstractModel;
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
public class CollaboratorActivityAreas extends AbstractModel{

    @ManyToOne
    @JoinColumn(name = "activityArea_id")
    @JsonIgnoreProperties("collaboratorActivityAreas")
    private ActivityAreas activityArea;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    @JsonIgnoreProperties("collaboratorActivityAreas")
    private Collaborators collaborator;
    
}
