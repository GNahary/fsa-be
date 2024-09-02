package com.ng.fsa_server.membersOnly.controller;

import com.ng.fsa_server.membersOnly.model.Message;
import com.ng.fsa_server.membersOnly.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/messages")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/groups/{groupId}")
    public List<Message> getAllMessages(@PathVariable String groupId){
        return messageService.findMessageForGroup(groupId);
    }
}
