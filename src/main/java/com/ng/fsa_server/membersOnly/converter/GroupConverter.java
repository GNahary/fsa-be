package com.ng.fsa_server.membersOnly.converter;

import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.model.Group;
import com.ng.fsa_server.membersOnly.model.Message;
import com.ng.fsa_server.membersOnly.model.Request;
import com.ng.fsa_server.membersOnly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupConverter {

    @Autowired
    private UserService userService;

    public GroupDTO toGroupDTO(Group group){
        return new GroupDTO(group.get_id(),
                group.getName(),
                userService.findUserById(group.getOwnerId()),
                userService.findUsersById(group.getMembersIds()),
                new Request[]{},
                new Message[]{}
                );
    }

    public List<GroupDTO> toListOfGroupDTO(List<Group> groups){
        List<GroupDTO> groupDTOS = new ArrayList<>();
        for (Group group:groups){
            groupDTOS.add(toGroupDTO(group));
        }

        return groupDTOS;
    }


}
