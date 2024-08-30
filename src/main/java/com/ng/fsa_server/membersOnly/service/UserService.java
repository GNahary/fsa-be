package com.ng.fsa_server.membersOnly.service;

import com.google.api.gax.rpc.NotFoundException;
import com.ng.fsa_server.membersOnly.dao.UserRepository;
import com.ng.fsa_server.membersOnly.dto.GroupDTO;
import com.ng.fsa_server.membersOnly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(String id){return userRepository.findByCustomId(id).orElseThrow();}

    public List<User> findUsersById(List<String> ids){
        List<User> users = new ArrayList<>();
        for (String id : ids){
            users.add(findUserById(id));
        }

        return users;
    }

}
