package com.example.springrecipe.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal amount;

    @ManyToOne
    private Recipe recipe;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
