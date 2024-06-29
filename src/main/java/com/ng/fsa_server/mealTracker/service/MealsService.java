package com.ng.fsa_server.mealTracker.service;

import com.ng.fsa_server.mealTracker.dao.MealsRepository;
import com.ng.fsa_server.mealTracker.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MealsService {

    @Autowired
    private MealsRepository mealsRepository;

    public List<Meal> findAll(){
        return mealsRepository.findAll();
    }

    public Meal addMeal(Meal meal){
        return mealsRepository.insert(meal);
    }

    public List<Meal> deleteMeal(String mealId){
        mealsRepository.deleteById(mealId);
        return findAll();
    }

    public List<Meal> mealsWithinDateRange(LocalDateTime from, LocalDateTime to){
        return mealsRepository.findByPlannedDateBetween(from,to);
    }

}
