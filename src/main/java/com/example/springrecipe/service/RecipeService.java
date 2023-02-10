package com.example.springrecipe.service;

import com.example.springrecipe.domain.Recipe;

import java.util.Optional;


public interface RecipeService {
    Iterable<Recipe> findAll();

    Optional<Recipe> findById(Long id);
}
