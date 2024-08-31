package com.ng.fsa_server.membersOnly.controller;

import com.google.firebase.auth.FirebaseAuthException;
import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.model.User;
import com.ng.fsa_server.membersOnly.service.FirebaseTokenService;
import com.ng.fsa_server.membersOnly.service.GroupService;
import com.ng.fsa_server.membersOnly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseTokenService firebaseTokenService;

    @GetMapping
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}/groups")
    public ResponseEntity<List<GroupDTO>> getGroupsForUser(@PathVariable String userId, @RequestHeader("AuthToken") String authToken){

        try {
            String uid = firebaseTokenService.verifyToken(authToken);

            if (!uid.equals(userId)) {
                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
            }

            return ResponseEntity.ok(groupService.getGroupForUser(userId));

        } catch (FirebaseAuthException e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.UNAUTHORIZED);
        }
    }
}
