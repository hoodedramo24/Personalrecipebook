package com.example.personalrecipebook;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {

    final RecipeRepository recipeRepository;
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    public void AddRecipe(Recipe newRecipe){
        recipeRepository.save(newRecipe);
    }

    public void RemoveRecipe(Recipe selectedRecipe){
        recipeRepository.deleteById(selectedRecipe.getiD());
    }

    public Iterable<Recipe> ShowAllRecipes(){
        return recipeRepository.findAll();
    }

    public Optional<Recipe> ShowRecipe(Recipe selectedRecipe){
        Optional<Recipe> result = Optional.of(new Recipe());
        if (recipeRepository.existsById(selectedRecipe.getiD())){
            result = recipeRepository.findById(selectedRecipe.getiD());
        }
        return result;
    }

    public void UpdateRecipe(Recipe selectedRecipe) {
        if (recipeRepository.existsById(selectedRecipe.getiD())) {
            recipeRepository.save(selectedRecipe);
        }
    }

    public Optional<Recipe> ShowRecipeByID(Long id){
        Optional<Recipe> result = Optional.of(new Recipe());
        if (recipeRepository.existsById(id)){
            result = recipeRepository.findById(id);
        }
        return result;
    }

}
