package com.ng.fsa_server.membersOnly.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.exception.UnAuthorizedUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private FirebaseTokenService firebaseTokenService;

    @Autowired
    private GroupService groupService;

    public String validateMember(String authToken, String groupId){
        try {
            String userId = firebaseTokenService.verifyToken(authToken);

            if (userId == null) {
                throw new UnAuthorizedUserException();
            }

            GroupDTO group = groupService.getGroupForUser(userId, groupId);
            if(!(isMember(userId, group) || isOwner(userId,group))){
                throw new UnAuthorizedUserException();
            }

            return userId;

        } catch (FirebaseAuthException e) {
            throw new UnAuthorizedUserException();
        }
    }




    private boolean isOwner(String userId, GroupDTO groupDTO){
        return groupDTO.getOwner().getCustomId().equals(userId);
    }

    private boolean isMember(String userId, GroupDTO groupDTO){
        return groupDTO.getMembers().stream().anyMatch(member->member.getCustomId().equals(userId));
    }
}
