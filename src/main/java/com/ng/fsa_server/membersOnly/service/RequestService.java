package com.ng.fsa_server.membersOnly.service;

import com.ng.fsa_server.membersOnly.converter.RequestConverter;
import com.ng.fsa_server.membersOnly.dao.RequestRepository;
import com.ng.fsa_server.membersOnly.dto.RequestDTO;
import com.ng.fsa_server.membersOnly.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    RequestConverter requestConverter;

    public Request createJoinRequest(String userId, String groupId){
        return requestRepository.insert(new Request(UUID.randomUUID().toString(), groupId, userId));
    }

    public Request findById(String requestId){
        return requestRepository.findByCustomId(requestId);
    }

    public List<RequestDTO> findRequestsForGroup(String groupId){
        return requestConverter.toRequestDTOList(requestRepository.findByGroupId(groupId));
    }

    public void deleteRequest(String requestId){
        requestRepository.deleteBy_id(requestId);
    }
}
