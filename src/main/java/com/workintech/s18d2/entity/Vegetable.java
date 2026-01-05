package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vegetable",schema = "fsweb")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @Column(name = "is_grown_on_tree")
    private boolean isGrownOnTree;


}
