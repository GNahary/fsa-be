package com.ng.fsa_server.mealTracker.service;

import com.ng.fsa_server.mealTracker.dao.RecipeRepository;
import com.ng.fsa_server.mealTracker.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Optional<Recipe> getRecipeById(String id) {
        return recipeRepository.findByCustomId(id);
    }

    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }
}
