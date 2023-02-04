package com.example.springrecipe.service;

import com.example.springrecipe.domain.Recipe;


public interface RecipeService {
    Iterable<Recipe> findAll();
}
