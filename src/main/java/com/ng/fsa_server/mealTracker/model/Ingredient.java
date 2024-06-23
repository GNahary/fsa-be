package com.ng.fsa_server.mealTracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "meal-tracker-ingredients")
public class Ingredient {
    @Id
    private String _id;
    private String name;
    private double amount;
    private String units;

    // Constructors
    public Ingredient() {
    }

    public Ingredient(String name, double amount, String units) {
        this.name = name;
        this.amount = amount;
        this.units = units;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
