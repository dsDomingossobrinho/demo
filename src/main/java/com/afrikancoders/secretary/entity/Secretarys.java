package com.afrikancoders.secretary.entity;

import com.afrikancoders.model.Users;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Secretarys extends Users {
    
}
