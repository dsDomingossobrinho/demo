package com.afrikancoders.speciality.entity;

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
public class Specialitys extends AbstractModel{

    @Column(nullable = false)
    @NotBlank(message = "Enter a Speciality")
    private String speciality;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnoreProperties("specialitys")
    private Status state;
    
}
