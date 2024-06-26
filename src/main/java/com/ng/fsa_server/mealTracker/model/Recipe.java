package com.ng.fsa_server.mealTracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "meal-tracker-recipes")
public class Recipe {

    @Id
    private String _id; // MongoDB's default ID field

    @Field(name = "id")
    @JsonProperty("id")
    private String customId; // Custom ID field
    private String name;
    private List<Ingredient> ingredients;
    private String originalRecipeLink;

    // Constructors
    public Recipe() {}

    public Recipe(String _id, String id, String name, List<Ingredient> ingredients, String originalRecipeLink) {
        this._id = _id;
        this.customId = id;
        this.name = name;
        this.ingredients = ingredients;
        this.originalRecipeLink = originalRecipeLink;
    }

    // Getters and Setters
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getOriginalRecipeLink() {
        return originalRecipeLink;
    }

    public void setOriginalRecipeLink(String originalRecipeLink) {
        this.originalRecipeLink = originalRecipeLink;
    }
}
