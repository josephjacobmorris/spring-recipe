package com.example.springrecipe.repositories;

import com.example.springrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Optional<String> findRecipeByDescription(String description);
}
