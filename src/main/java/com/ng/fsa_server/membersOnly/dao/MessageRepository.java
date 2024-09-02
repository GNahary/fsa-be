package com.ng.fsa_server.membersOnly.dao;

import com.ng.fsa_server.membersOnly.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByGroupId(String groupId);
    Message insert(Message message);
}
