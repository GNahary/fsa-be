package com.ng.fsa_server.membersOnly.model.dao;

import com.ng.fsa_server.membersOnly.model.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();
}
