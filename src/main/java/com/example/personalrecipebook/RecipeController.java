package com.example.personalrecipebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public void PostRecipe(@RequestBody Recipe recipe) {
        recipeService.AddRecipe(recipe);
    }


    @DeleteMapping("/{id}")
    public void DeleteRecipe(@PathVariable Long id) {
        recipeService.RemoveRecipeByID(id);
    }

    @GetMapping
    public Iterable<Recipe> GetAllRecipes() {
        return recipeService.ShowAllRecipes();
    }

    @GetMapping("/{id}")
    public Optional<Recipe> GetRecipe(@PathVariable Long id) {
        return recipeService.ShowRecipeByID(id);
    }


    @PutMapping("/{id}")
    public void PutRecipe(@RequestBody Recipe recipe, @PathVariable Long id) {
        recipeService.UpdateRecipe(recipe, id);
    }

}
