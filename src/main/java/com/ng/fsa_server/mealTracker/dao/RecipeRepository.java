package com.ng.fsa_server.mealTracker.dao;

import com.ng.fsa_server.mealTracker.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    Optional<Recipe> findBy_id(String _id);
    Optional<Recipe> findByCustomId(@Param("id") String id);
    List<Recipe> findAll();
}