package com.example.springrecipe.converters;

import com.example.springrecipe.commands.RecipeCommand;
import com.example.springrecipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final IngredientCommandToIngredient ingredientCommandToIngredient;
    private final NotesCommandToNotes notesCommandToNotes;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientCommandToIngredient, NotesCommandToNotes notesCommandToNotes) {
        this.ingredientCommandToIngredient = ingredientCommandToIngredient;
        this.notesCommandToNotes = notesCommandToNotes;
    }

    @Override
    public Recipe convert(RecipeCommand source) {
        Recipe recipe = new Recipe();
        recipe.setIngredients(source.getIngredients().stream().map(ingredientCommandToIngredient::convert).collect(Collectors.toSet()));
        recipe.setNotes(notesCommandToNotes.convert(source.getNotes()));
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setDescription(source.getDescription());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDirections(source.getDirections());
        recipe.setId(source.getId());
        recipe.setServings(source.getServings());
        recipe.setUrl(source.getUrl());
        recipe.setSource(source.getSource());
        recipe.setImage(source.getImage());
        return recipe;
    }
}
