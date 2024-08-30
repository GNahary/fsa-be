package com.ng.fsa_server.membersOnly.dto;

import com.ng.fsa_server.membersOnly.model.Message;
import com.ng.fsa_server.membersOnly.model.Request;
import com.ng.fsa_server.membersOnly.model.User;

import java.util.List;

public class GroupDTO {

    private String id;
    private String name;
    private User owner;
    private List<User> members;
    private Request[] requests;
    private Message[] messages;

    public GroupDTO() {
    }

    public GroupDTO(String id, String name, User owner, List<User> members, Request[] requests, Message[] messages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.members = members;
        this.requests = requests;
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public Request[] getRequests() {
        return requests;
    }

    public void setRequests(Request[] requests) {
        this.requests = requests;
    }

    public Message[] getMessages() {
        return messages;
    }

    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}
