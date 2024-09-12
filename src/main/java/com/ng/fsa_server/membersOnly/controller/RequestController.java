package com.ng.fsa_server.membersOnly.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.dto.RequestDTO;
import com.ng.fsa_server.membersOnly.model.Request;
import com.ng.fsa_server.membersOnly.service.FirebaseTokenService;
import com.ng.fsa_server.membersOnly.service.GroupService;
import com.ng.fsa_server.membersOnly.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/requests")
@CrossOrigin(origins = "http://localhost:4200")
public class RequestController {

    @Autowired
    RequestService requestService;

    @Autowired
    GroupService groupService;

    @Autowired
    private FirebaseTokenService firebaseTokenService;

    @PostMapping("/{requestId}/accept")
    public ResponseEntity<List<RequestDTO>> acceptRequest(@PathVariable String requestId, @RequestHeader("AuthToken") String authToken){

        try {
            String approverId = firebaseTokenService.verifyToken(authToken);

            if (approverId == null) {
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
            }

            Request request = requestService.findById(requestId);
            String requestedGroupId = request.getGroupId();
            String userId = request.getUserId();

            GroupDTO requestedGroup = groupService.getGroupForUser(approverId, requestedGroupId);

            if(requestedGroup.getOwner().getCustomId().equals(approverId)){
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
            }

            groupService.acceptRequest(userId, requestedGroupId, requestId);
            List<RequestDTO> currentGroupRequests = requestService.findRequestsForGroup(requestedGroupId);
            return ResponseEntity.ok(currentGroupRequests);

        } catch (FirebaseAuthException e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
        }
    }


    @PostMapping("/{requestId}/reject")
    public ResponseEntity<List<RequestDTO>> rejectRequest(@PathVariable String requestId, @RequestHeader("AuthToken") String authToken){
        try {
            String approverId = firebaseTokenService.verifyToken(authToken);

            if (approverId == null) {
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
            }

            Request request = requestService.findById(requestId);
            String requestedGroupId = request.getGroupId();

            GroupDTO requestedGroup = groupService.getGroupForUser(approverId, requestedGroupId);

            if(requestedGroup.getOwner().getCustomId().equals(approverId)){
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
            }

            groupService.rejectRequest(requestId);
            List<RequestDTO> currentGroupRequests = requestService.findRequestsForGroup(requestedGroupId);
            return ResponseEntity.ok(currentGroupRequests);

        } catch (FirebaseAuthException e) {
            return new ResponseEntity<>(Collections.emptyList(), HttpStatus.UNAUTHORIZED);
        }
    }
}
