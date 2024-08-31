package com.ng.fsa_server.membersOnly.service;

import com.ng.fsa_server.membersOnly.dao.RequestRepository;
import com.ng.fsa_server.membersOnly.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public Request createJoinRequest(String userId, String groupId){
        return requestRepository.insert(new Request(UUID.randomUUID().toString(), groupId, userId));
    }
}
