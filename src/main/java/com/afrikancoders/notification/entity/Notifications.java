package com.afrikancoders.notification.entity;

import java.lang.reflect.Type;

import com.afrikancoders.collaborator.entity.Collaborators;
import com.afrikancoders.company.entity.Companys;
import com.afrikancoders.distributor.entity.Distributors;
import com.afrikancoders.furnisher.entity.Furnishers;
import com.afrikancoders.model.AbstractModel;
import com.afrikancoders.typeNotification.entity.TypeNotifications;
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
public class Notifications extends AbstractModel{

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonIgnoreProperties("notifications")
    private Companys company;

    @ManyToOne
    @JoinColumn(name = "collaborator_id")
    @JsonIgnoreProperties("notifications")
    private Collaborators collaborator;

    @ManyToOne
    @JoinColumn(name = "furnisher_id")
    @JsonIgnoreProperties("notifications")
    private Furnishers furnisher;

    @ManyToOne
    @JoinColumn(name = "typeNotification_id")
    @JsonIgnoreProperties("notifications")
    private Distributors distributor;

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    @JsonIgnoreProperties("notifications")
    private TypeNotifications typeNotification;

    @Column(nullable = false)
    @NotBlank(message = "Enter a description")
    private String description;
    
}
