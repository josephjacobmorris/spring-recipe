package com.example.springrecipe.repositories;

import com.example.springrecipe.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Ingredient findIngredientByIdAndRecipeId(Long id, Long recipeId);
}
