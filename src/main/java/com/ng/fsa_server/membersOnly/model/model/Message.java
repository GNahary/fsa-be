package com.ng.fsa_server.membersOnly.model.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members-only-messages")
public class Message {

    @Id
    private String _id; // MongoDB's default ID field


    private String userName;
    private String text;

    public Message() {
    }


}
