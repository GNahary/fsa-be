package com.ng.fsa_server.mealTracker.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shopping-list")
public class ShoppingListController {

    @GetMapping
    public String getShoppingList(){
        return "Get shopping list not implemented";
    }
}
