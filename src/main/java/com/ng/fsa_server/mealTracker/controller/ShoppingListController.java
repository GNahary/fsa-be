package com.ng.fsa_server.mealTracker.controller;

import com.ng.fsa_server.mealTracker.model.Ingredient;
import com.ng.fsa_server.mealTracker.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("shopping-list")
public class ShoppingListController {

    @Autowired
    ShoppingListService shoppingListService;

    @GetMapping
    public List<Ingredient> getShoppingList(){
        return shoppingListService.getShoppingList();
    }
}
