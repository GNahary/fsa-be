package com.ng.fsa_server.membersOnly.controller;

import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.model.User;
import com.ng.fsa_server.membersOnly.service.GroupService;
import com.ng.fsa_server.membersOnly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}/groups")
    public List<GroupDTO> getGroupsForUser(@PathVariable String userId){
        return groupService.getGroupForUser(userId);
    }
}
