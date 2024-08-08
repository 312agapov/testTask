package com.example.TestTask.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
public class Computer extends Product {

    @Enumerated(value = EnumType.STRING)
    private FormFactor formFactor;
    public enum FormFactor {
        DESKTOP, NETTOP, MONOBLOCK
    }
}

