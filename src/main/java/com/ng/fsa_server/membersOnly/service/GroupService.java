package com.ng.fsa_server.membersOnly.service;

import com.ng.fsa_server.membersOnly.converter.GroupConverter;
import com.ng.fsa_server.membersOnly.dao.GroupRepository;
import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    GroupConverter groupConverter;

    public List<GroupDTO> getAllGroups(){
        return groupConverter.toListOfGroupDTO(groupRepository.findAll());
    }

    public List<GroupDTO> getGroupForUser(String userId){
        return getAllGroups().stream().filter(groupDTO -> isUserGroupMember(groupDTO, userId)).collect(Collectors.toList());
    }

    private boolean isUserGroupMember(GroupDTO group, String userId){
        boolean isOwner = group.getOwner().getCustomId().equals(userId);
        boolean isMember = group.getMembers().stream().map(User::getCustomId).filter(memberId->memberId.equals(userId)).findFirst().isEmpty();
        return isMember || isOwner;
    }

}
