package com.ng.fsa_server.mealTracker.controller;

import com.ng.fsa_server.mealTracker.model.Ingredient;
import com.ng.fsa_server.mealTracker.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ingredients")
public class IngredientsController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients(){
        return ingredientService.findAll();
    }

    @PostMapping
    public Ingredient addIngredient(@RequestBody Ingredient ingredient){
        return ingredientService.addIngredient(ingredient);
    }

    @DeleteMapping("/{ingredientName}")
    public List<Ingredient> deleteIngredient(@PathVariable String ingredientName){
        return ingredientService.deleteIngredient(ingredientName);
    }
}
