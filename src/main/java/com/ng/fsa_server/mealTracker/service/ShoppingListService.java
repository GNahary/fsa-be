package com.ng.fsa_server.mealTracker.service;

import com.ng.fsa_server.mealTracker.model.Ingredient;
import com.ng.fsa_server.mealTracker.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ShoppingListService {
    @Autowired
    private MealsService mealsService;

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private IngredientService ingredientService;

    public List<Ingredient> getShoppingList(){

        Map<String,Ingredient> requiredIngredientsMap = new HashMap<>();
        getNextWeekMeals().stream()
                .map(meal -> recipeService.getRecipeById(meal.getRecipeId()))
                .filter(Optional::isPresent)
                .flatMap(recipe -> recipe.get().getIngredients().stream())
                .forEach(ingredient->{reduceIngredients(requiredIngredientsMap, ingredient);});

        List<Ingredient> existingIngredients = ingredientService.findAll();

        for (Ingredient existingIngredient:existingIngredients){
            if(requiredIngredientsMap.containsKey(existingIngredient.getName())){
                Ingredient requiredIngredient = requiredIngredientsMap.get(existingIngredient.getName());
                if(requiredIngredient.getAmount() <= existingIngredient.getAmount()){
                    requiredIngredientsMap.remove(requiredIngredient.getName());
                } else{
                    requiredIngredient.setAmount(requiredIngredient.getAmount()-existingIngredient.getAmount());
                }
            }
        }

        return requiredIngredientsMap.values().stream().toList();
    }


    private void reduceIngredients(Map<String,Ingredient> ingredientMap, Ingredient ingredient){
        Ingredient temp = ingredientMap.get(ingredient.getName());
        if(temp != null){
            temp.setAmount(temp.getAmount() + ingredient.getAmount());
        }else{
            ingredientMap.put(ingredient.getName(), ingredient);
        }
    }

    private List<Meal> getNextWeekMeals(){
        LocalDateTime today = LocalDate.now().atStartOfDay();
        LocalDateTime inAWeek = today.plusWeeks(1);
        return mealsService.mealsWithinDateRange(today,inAWeek);
    }
}
