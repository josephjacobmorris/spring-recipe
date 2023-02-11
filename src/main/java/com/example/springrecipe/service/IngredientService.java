package com.example.springrecipe.service;

import com.example.springrecipe.commands.IngredientCommand;
import com.example.springrecipe.domain.Ingredient;

import java.util.Optional;

public interface IngredientService {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(Long id);

    Optional<IngredientCommand> findCommandById(Long id);

    Ingredient save(Ingredient ingredient);

    void deleteById(Long id);
}
