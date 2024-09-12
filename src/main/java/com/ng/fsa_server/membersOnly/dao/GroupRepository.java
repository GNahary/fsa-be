package com.ng.fsa_server.membersOnly.dao;

import com.ng.fsa_server.membersOnly.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {
    List<Group> findAll();
    Optional<Group> findBy_id(String _id);
    Group insert(Group group);
}
