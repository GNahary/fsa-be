package com.ng.fsa_server.mealTracker.controller;

import com.ng.fsa_server.mealTracker.model.Meal;
import com.ng.fsa_server.mealTracker.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("meals")
public class MealsController {

    @Autowired
    private MealsService mealsService;

    @GetMapping
    public List<Meal> getMeals(){
        return mealsService.findAll();
    }

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal){
        return mealsService.addMeal(meal);
    }

    @DeleteMapping("/{mealId}")
    public List<Meal> deleteMeal(@PathVariable String mealId){
        return mealsService.deleteMeal(mealId);
    }
}
