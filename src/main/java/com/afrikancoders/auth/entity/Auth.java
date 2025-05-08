package com.afrikancoders.auth.entity;

import com.afrikancoders.model.AbstractModel;
import com.afrikancoders.role.entity.Roles;
import com.afrikancoders.state.entity.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auth extends AbstractModel{

    @Column(nullable = false, unique = true)
    @Email(message = "Enter a valid email")
    @NotBlank(message = "Enter a email")
    private String email;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnoreProperties("auths")
    private Status state;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @JsonIgnoreProperties("auths")
    private Roles role;

}
