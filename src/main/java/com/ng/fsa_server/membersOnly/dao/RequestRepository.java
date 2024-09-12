package com.ng.fsa_server.membersOnly.dao;

import com.ng.fsa_server.membersOnly.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends MongoRepository<Request, String> {

    Request findBy_id(String _id);
    Request findByCustomId(@Param("id") String id);
    Request insert(Request request);
    List<Request> findByGroupId(String groupId);
    void deleteBy_id(String _id);
}
