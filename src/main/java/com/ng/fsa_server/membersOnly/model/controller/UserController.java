package com.ng.fsa_server.membersOnly.model.controller;

import com.ng.fsa_server.membersOnly.model.model.User;
import com.ng.fsa_server.membersOnly.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}/groups")
    public String requestToJoinGroup(@PathVariable String userId){
        return "got request to get groups of user" + userId;
    }
}
