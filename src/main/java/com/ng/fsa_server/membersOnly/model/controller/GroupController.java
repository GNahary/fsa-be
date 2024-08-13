package com.ng.fsa_server.membersOnly.model.controller;

import com.ng.fsa_server.membersOnly.model.model.Group;
import com.ng.fsa_server.membersOnly.model.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<Group> getAllGroups(){
        return groupService.getAllGroups();
    }

//    @PostMapping("/{groupId}/request}")
//    public String requestToJoinGroup(@PathVariable String groupId){
//        return "got request to join" + groupId;
//    }
}
