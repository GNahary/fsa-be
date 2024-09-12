package com.ng.fsa_server.membersOnly.converter;

import com.ng.fsa_server.membersOnly.dto.MessageDTO;
import com.ng.fsa_server.membersOnly.model.Message;
import com.ng.fsa_server.membersOnly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageConverter {

    @Autowired
    UserService userService;

    public MessageDTO toMessageDTO(Message message){
        return new MessageDTO(message.getUserId(), userService.findUserById(message.getUserId()).getFullName(), message.getGroupId(), message.getText());
    }

    public List<MessageDTO> toMessageDTOList(List<Message> messages){
        List<MessageDTO> messageDTOS = new ArrayList<>();
        for (Message message : messages){
            messageDTOS.add(toMessageDTO(message));
        }
        return messageDTOS;
    }
}
