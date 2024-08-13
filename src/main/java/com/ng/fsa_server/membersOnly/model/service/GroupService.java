package com.ng.fsa_server.membersOnly.model.service;

import com.ng.fsa_server.membersOnly.model.dao.GroupRepository;
import com.ng.fsa_server.membersOnly.model.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroups(){
        return groupRepository.findAll();
    }
}
