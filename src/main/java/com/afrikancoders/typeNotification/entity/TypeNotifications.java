package com.afrikancoders.typeNotification.entity;

import com.afrikancoders.model.AbstractModel;
import com.afrikancoders.state.entity.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TypeNotifications extends AbstractModel{

    @Column(nullable = false)
    @NotBlank(message = "Enter a Type Notification")
    private String type;
    
    private String description;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnoreProperties("typeNotifications")
    private Status state;
    
}
