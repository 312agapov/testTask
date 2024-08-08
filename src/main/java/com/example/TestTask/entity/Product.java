package com.example.TestTask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected UUID id;

    @NotBlank(message = "Обязательное поле!")
    protected String serialNumber;

    @NotBlank(message = "Обязательное поле!")
    protected String maker;

    @Min(value = 0, message = "Цена должна быть больше 0")
    protected int price;

    @Min(value = 0, message = "Количество товара должна быть больше 0")
    protected int count;

}
