package com.ng.fsa_server.membersOnly.controller;

import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/groups")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupDTO> getAllGroups(){
        return groupService.getAllGroups();
    }

}
