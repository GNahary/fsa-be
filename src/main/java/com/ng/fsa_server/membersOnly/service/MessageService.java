package com.ng.fsa_server.membersOnly.service;

import com.ng.fsa_server.membersOnly.converter.MessageConverter;
import com.ng.fsa_server.membersOnly.dao.MessageRepository;
import com.ng.fsa_server.membersOnly.dto.MessageDTO;
import com.ng.fsa_server.membersOnly.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageConverter messageConverter;

    public List<MessageDTO> findMessageForGroup(String groupId){
        return messageConverter.toMessageDTOList(messageRepository.findByGroupId(groupId));
    }

    public MessageDTO createMessage(String groupId, String userId, String messageText){
        Message newMessage = new Message();
        newMessage.setText(messageText);
        newMessage.setGroupId(groupId);
        newMessage.setUserId(userId);
        return messageConverter.toMessageDTO(messageRepository.insert(newMessage));
    }
}
