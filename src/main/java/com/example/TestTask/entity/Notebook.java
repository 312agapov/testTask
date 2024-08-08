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
public class Notebook extends Product {

    private int diagonal;

    private enum DiagonalType{
        A(13), B(14), C(15), D(17);
        @Enumerated(value = EnumType.STRING)
        private int value;

        DiagonalType(int value) {
            this.value = value;
        }
    }

}

