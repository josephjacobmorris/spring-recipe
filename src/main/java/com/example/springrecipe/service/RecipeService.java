package com.example.springrecipe.service;

import com.example.springrecipe.commands.RecipeCommand;
import com.example.springrecipe.domain.Recipe;

import java.util.Optional;


public interface RecipeService {
    Iterable<Recipe> findAll();

    Optional<Recipe> findById(Long id);

    Optional<RecipeCommand> findCommandById(Long id);

    RecipeCommand save(RecipeCommand recipeCommand);
}
