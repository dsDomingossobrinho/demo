package com.afrikancoders.model;

import com.afrikancoders.auth.entity.Auth;
import com.afrikancoders.state.entity.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Users extends AbstractModel {

    private String img;

    @Column(name = "phone", nullable = false, unique = true)
    private String phone;
    
    @Column(name = "address", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "state_id")
    @JsonIgnoreProperties("users")
    private Status state;

    @ManyToOne
    @JoinColumn(name = "auth_id")
    @JsonIgnoreProperties("users")
    private Auth auth;
    
}
