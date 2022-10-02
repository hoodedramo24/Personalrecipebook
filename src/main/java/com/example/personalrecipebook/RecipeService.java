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

    public void RemoveRecipeByID(Long id){
        if(recipeRepository.existsById(id)){
            recipeRepository.deleteById(id);
        }
    }

    public Iterable<Recipe> ShowAllRecipes(){
        return recipeRepository.findAll();
    }

    public Optional<Recipe> ShowRecipeByID(Long id){
        Optional<Recipe> result = Optional.of(new Recipe());
        if (recipeRepository.existsById(id)){
            result = recipeRepository.findById(id);
        }
        return result;
    }

    public void UpdateRecipe(Recipe selectedRecipe, Long id) {
        if (recipeRepository.existsById(id) && id.equals(selectedRecipe.getiD())) {
            recipeRepository.save(selectedRecipe);
        }
    }



}
