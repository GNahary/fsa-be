package com.ng.fsa_server.membersOnly.model.service;

import com.ng.fsa_server.membersOnly.model.dao.UserRepository;
import com.ng.fsa_server.membersOnly.model.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
