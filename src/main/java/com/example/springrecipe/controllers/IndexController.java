package com.example.springrecipe.controllers;

import com.example.springrecipe.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/","","/index","/index/"})
    String index(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }
}
