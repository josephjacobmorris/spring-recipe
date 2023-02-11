package com.example.springrecipe.controllers;

import com.example.springrecipe.commands.RecipeCommand;
import com.example.springrecipe.domain.Recipe;
import com.example.springrecipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        Optional<Recipe> recipeId = recipeService.findById(Long.valueOf(id));
        if (recipeId.isEmpty()) {
            throw new IllegalStateException("No recipe with id " + id);
        }
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)).get());
        return "recipe/show";
    }

    @RequestMapping("/update/{id}")
    public String updateById(@PathVariable String id, Model model) {
        Optional<Recipe> recipeId = recipeService.findById(Long.valueOf(id));
        if (recipeId.isEmpty()) {
            throw new IllegalStateException("No recipe with id " + id);
        }
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)).get());
        return "recipe/recipeform";
    }

    @RequestMapping("/new")
    public String newRecipe( Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @PostMapping("/")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedRecipeCommand = recipeService.save(command);

        return "redirect:/recipe/show/" + savedRecipeCommand.getId();
    }
}
