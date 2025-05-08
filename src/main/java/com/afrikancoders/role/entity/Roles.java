package com.afrikancoders.role.entity;

import com.afrikancoders.model.AbstractModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Roles extends AbstractModel {

    @Column(nullable = false)
    @NotBlank(message = "Enter a role")
    private String role;
    
    private String description;
    
}
