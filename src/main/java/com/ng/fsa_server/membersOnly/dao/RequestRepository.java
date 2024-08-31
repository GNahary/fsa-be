package com.ng.fsa_server.membersOnly.dao;

import com.ng.fsa_server.membersOnly.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestRepository extends MongoRepository<Request, String> {

    Request insert(Request request);
}
