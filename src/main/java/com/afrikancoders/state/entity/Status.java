package com.afrikancoders.state.entity;

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
public class Status extends AbstractModel {

    @Column(nullable = false)
    @NotBlank(message = "Enter a state")
    private String state;
    
}
