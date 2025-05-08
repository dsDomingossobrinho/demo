package com.afrikancoders.notification.entity;

import com.afrikancoders.model.AbstractModel;
import com.afrikancoders.typeNotification.entity.TypeNotifications;
import com.afrikancoders.userIdentificator.entity.UserIdentificators;
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
    @JoinColumn(name = "receiver_id")
    @JsonIgnoreProperties("notifications")
    private UserIdentificators receiver;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    @JsonIgnoreProperties("notifications")
    private UserIdentificators sender;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    @JsonIgnoreProperties("notifications")
    private UserIdentificators destination;

    @ManyToOne
    @JoinColumn(name = "type_notification_id")
    @JsonIgnoreProperties("notifications")
    private TypeNotifications typeNotification;

    @Column(nullable = false)
    @NotBlank(message = "Enter a description")
    private String description;
    
}
