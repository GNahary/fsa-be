package com.ng.fsa_server.membersOnly.dao;

import com.ng.fsa_server.membersOnly.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();
    Optional<User> findByCustomId(@Param("id") String id);

}
