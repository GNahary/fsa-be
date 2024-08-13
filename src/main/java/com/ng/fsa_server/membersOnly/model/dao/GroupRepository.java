package com.ng.fsa_server.membersOnly.model.dao;

import com.ng.fsa_server.membersOnly.model.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {
    List<Group> findAll();
//    Optional<Group> findBy_id(String _id);
//    Group insert(Group group);
//
//    void deleteByName(String name);
}
