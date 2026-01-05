package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="fruit",schema="fsweb")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    @Column(name="fruit_type")
    private FruitType fruitType;
}
