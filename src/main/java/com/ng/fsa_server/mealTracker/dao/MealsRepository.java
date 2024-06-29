package com.ng.fsa_server.mealTracker.dao;

import com.ng.fsa_server.mealTracker.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MealsRepository extends MongoRepository<Meal, String> {
    Optional<Meal> findBy_id(String _id);
    List<Meal> findAll();
    Meal insert(Meal recipe);

    List<Meal> findByPlannedDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}

