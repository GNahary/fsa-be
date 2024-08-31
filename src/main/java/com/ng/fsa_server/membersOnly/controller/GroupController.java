package com.ng.fsa_server.membersOnly.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.model.Request;
import com.ng.fsa_server.membersOnly.service.FirebaseTokenService;
import com.ng.fsa_server.membersOnly.service.GroupService;
import com.ng.fsa_server.membersOnly.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<GroupDTO> getAllGroups(){
        return groupService.getAllGroups();
    }

    @Autowired
    private FirebaseTokenService firebaseTokenService;

    @Autowired
    private RequestService requestService;

    @PostMapping("/{groupId}/request")
    public ResponseEntity<String> createRequest(@PathVariable String groupId, @RequestHeader("AuthToken") String authToken) {

        try {
            String userId = firebaseTokenService.verifyToken(authToken);

            if (userId == null) {
                return new ResponseEntity<>("Must be logged in", HttpStatus.UNAUTHORIZED);
            }

            Request newReq = requestService.createJoinRequest(userId, groupId);
            return ResponseEntity.ok("Request created to join" + groupId);

        } catch (FirebaseAuthException e) {
            return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO groupRequestDTO, @RequestHeader("AuthToken") String authToken) {

        try {
            String userId = firebaseTokenService.verifyToken(authToken);

            if (userId == null) {
                return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
            }

            GroupDTO newGroup = groupService.createGroup(userId, groupRequestDTO.getName());
            return ResponseEntity.ok(newGroup);

        } catch (FirebaseAuthException e) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
    }








}
