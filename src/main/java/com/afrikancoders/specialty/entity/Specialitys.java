package com.afrikancoders.specialty.entity;

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
public class Specialitys extends AbstractModel{

    @Column(nullable = false)
    @NotBlank(message = "Enter a Speciality")
    private String speciality;
    
}
