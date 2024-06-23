package com.ng.fsa_server.mealTracker.service;

import com.ng.fsa_server.mealTracker.dao.IngredientsRepository;
import com.ng.fsa_server.mealTracker.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<Ingredient> findAll(){
        return ingredientsRepository.findAll();
    }

    public Ingredient addIngredient(Ingredient ingredient){
        return ingredientsRepository.insert(ingredient);
    }

    public List<Ingredient> deleteIngredient(String ingredientName){
        ingredientsRepository.deleteByName(ingredientName);
        return findAll();
    }

}
