package com.ng.fsa_server.membersOnly.service;

import com.ng.fsa_server.membersOnly.converter.GroupConverter;
import com.ng.fsa_server.membersOnly.dao.GroupRepository;
import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.dto.RequestDTO;
import com.ng.fsa_server.membersOnly.model.Group;
import com.ng.fsa_server.membersOnly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private RequestService requestService;

    @Autowired
    private MessageService messageService;

    @Autowired
    GroupConverter groupConverter;

    public List<GroupDTO> getAllGroups(){
        return groupConverter.toListOfGroupDTO(groupRepository.findAll());
    }

    public GroupDTO getGroupForUser(String userId, String groupId){
        GroupDTO groupDTO = groupConverter.toGroupDTO(groupRepository.findBy_id(groupId).orElseThrow());
        if(isOwner(userId, groupDTO)){
            List<RequestDTO> requests = requestService.findRequestsForGroup(groupDTO.getCustomId());
            groupDTO.setRequests(requests);
        }

        if(isOwner(userId, groupDTO) || isMember(userId, groupDTO)){
            groupDTO.setMessages(messageService.findMessageForGroup(groupDTO.getCustomId()));
        }

        return groupDTO;
    }

    private boolean isOwner(String userId, GroupDTO groupDTO){
        return groupDTO.getOwner().getCustomId().equals(userId);
    }

    private boolean isMember(String userId, GroupDTO groupDTO){
        return groupDTO.getMembers().stream().anyMatch(member->member.getCustomId().equals(userId));
    }



    public List<GroupDTO> getAllGroupsForUser(String userId){
        return getAllGroups().stream().filter(groupDTO -> isUserGroupMember(groupDTO, userId)).collect(Collectors.toList());
    }

    private boolean isUserGroupMember(GroupDTO group, String userId){
        boolean isOwner = group.getOwner().getCustomId().equals(userId);
        boolean isMember = group.getMembers().stream().map(User::getCustomId).anyMatch(memberId->memberId.equals(userId));
        return isMember || isOwner;
    }

    public GroupDTO createGroup(String userId, String groupName){
        return groupConverter.toGroupDTO(groupRepository.insert(new Group(UUID.randomUUID().toString(), groupName, userId)));
    }

    public void addMember(String requestedGroupId, String userId){
        Group requestedGroup = groupRepository.findByCustomId(requestedGroupId).orElseThrow();
        List<String> memberIds = requestedGroup.getMembersIds();
        if(!memberIds.contains(userId)){
            memberIds.add(userId);
        }
        groupRepository.save(requestedGroup);
    }


    public void acceptRequest(String userId, String requestedGroupId, String requestId){
        addMember(requestedGroupId, userId);
        requestService.deleteRequest(requestId);
    }


    public void rejectRequest(String requestId){
        requestService.deleteRequest(requestId);
    }


    public GroupDTO addMessageToGroup(String groupId, String userId, String messageText){
        Group group = groupRepository.findBy_id(groupId).orElseThrow();
        messageService.createMessage(group.getCustomId(),userId,messageText);
        return getGroupForUser(userId, groupId);
    }

}
