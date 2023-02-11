package com.example.springrecipe.controllers;

import com.example.springrecipe.domain.Ingredient;
import com.example.springrecipe.domain.Recipe;
import com.example.springrecipe.service.IngredientService;
import com.example.springrecipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class IngredientController {
    private final IngredientService ingredientService;
    private final RecipeService recipeService;

    public IngredientController(IngredientService ingredientService, RecipeService recipeService) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/{id}/ingredient/index")
    public String listIngredients(@PathVariable String id, Model model) {
        Optional<Recipe> recipe = recipeService.findById(Long.valueOf(id));
        Set<Ingredient> ingredients = new HashSet<>();
        if (recipe.isPresent()) {
            ingredients = recipe.get().getIngredients();
        }
        model.addAttribute("ingredients", ingredients);
        return "ingredient/index";
    }

    @RequestMapping("/recipe/{id}/ingredient/show/{ingredientId}")
    public String showIngredient(@PathVariable Long id, @PathVariable Long ingredientId, Model model) {
        Ingredient ingredient = ingredientService.findIngredientByIdAndRecipeId(id, ingredientId);
        model.addAttribute("ingredient", ingredient);
        return "ingredient/show";
    }
}
