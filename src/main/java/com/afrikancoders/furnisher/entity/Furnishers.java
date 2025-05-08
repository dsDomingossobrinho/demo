package com.afrikancoders.furnisher.entity;

import com.afrikancoders.model.Users;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Furnishers extends Users {
    
}
