package com.afrikancoders.role.entity;

import com.afrikancoders.model.AbstractModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles extends AbstractModel {

    @Column(nullable = false)
    @NotBlank(message = "Enter a role")
    private String role;
    
    private String description;
    
}
