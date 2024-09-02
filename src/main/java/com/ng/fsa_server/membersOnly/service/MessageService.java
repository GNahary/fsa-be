package com.ng.fsa_server.membersOnly.service;

import com.ng.fsa_server.membersOnly.dao.MessageRepository;
import com.ng.fsa_server.membersOnly.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> findMessageForGroup(String groupId){
        return messageRepository.findByGroupId(groupId);
    }

}
