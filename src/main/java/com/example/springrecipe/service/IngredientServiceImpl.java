package com.example.springrecipe.service;

import com.example.springrecipe.commands.IngredientCommand;
import com.example.springrecipe.converters.IngredientToIngredientCommand;
import com.example.springrecipe.domain.Ingredient;
import com.example.springrecipe.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngredientServiceImpl implements IngredientService{
    private final IngredientRepository ingredientRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.ingredientRepository = ingredientRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public Optional<Ingredient> findById(Long id) {
        return ingredientRepository.findById(id);
    }

    @Override
    public Optional<IngredientCommand> findCommandById(Long id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        return ingredient.map(ingredientToIngredientCommand::convert);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteById(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public Ingredient findIngredientByIdAndRecipeId(Long id, Long recipeId) {
        return ingredientRepository.findIngredientByIdAndRecipeId(id, recipeId);
    }
}
