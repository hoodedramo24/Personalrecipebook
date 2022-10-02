package com.example.personalrecipebook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    final RecipeService recipeService;
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public void PostRecipe(@RequestBody Recipe recipe ){
        recipeService.AddRecipe(recipe);
    }

    @DeleteMapping
    public void DeleteRecipe(@RequestBody Recipe recipe){
        recipeService.RemoveRecipe(recipe);
    }

    @GetMapping
    public Iterable<Recipe> GetAllRecipes(){
        return recipeService.ShowAllRecipes();
    }

    @PutMapping
    public void PutRecipe(@RequestBody Recipe recipe){
        recipeService.UpdateRecipe(recipe);
    }

    @GetMapping("/{id}")
    public Optional<Recipe> GetRecipe(@PathVariable Long id){
        return recipeService.ShowRecipeByID(id);
    }
}
