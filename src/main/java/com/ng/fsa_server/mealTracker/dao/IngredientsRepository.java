package com.ng.fsa_server.mealTracker.dao;

import com.ng.fsa_server.mealTracker.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredientsRepository extends MongoRepository<Ingredient, String> {
    Optional<Ingredient> findBy_id(String _id);
    List<Ingredient> findAll();
    Ingredient insert(Ingredient ingredient);

    void deleteByName(String name);
}
