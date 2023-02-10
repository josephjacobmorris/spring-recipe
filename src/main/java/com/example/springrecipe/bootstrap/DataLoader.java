package com.example.springrecipe.bootstrap;

import com.example.springrecipe.domain.*;
import com.example.springrecipe.repositories.IngredientRepository;
import com.example.springrecipe.repositories.NotesRepository;
import com.example.springrecipe.repositories.RecipeRepository;
import com.example.springrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final NotesRepository notesRepository;
    private final IngredientRepository ingredientRepository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, NotesRepository notesRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.notesRepository = notesRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Used here to load data");

        Notes notes = new Notes();
        notes.setRecipeNotes("recipe notes");
        notesRepository.save(notes);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setAmount(BigDecimal.valueOf(10));
        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findUnitOfMeasureByDescription("Teaspoon");
        ingredient1.setUom(teaspoon.get());
        ingredient1.setDescription("ingredient1 description");


        Recipe recipe = new Recipe();
        recipe.setDifficulty(Difficulty.EASY);
        recipe.setDescription("dummy description");
        recipe.setDirections("dummy directions");
        recipe.setCookTime(10);
        recipe.setPrepTime(20);
        recipe.setNotes(notes);

        recipe.setIngredients(Collections.singleton(ingredient1));
        ingredient1.setRecipe(recipe);
        recipeRepository.save(recipe);
        notes.setRecipe(recipe);
        notesRepository.save(notes);

    }
}
