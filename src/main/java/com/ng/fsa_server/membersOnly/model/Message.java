package com.ng.fsa_server.membersOnly.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members-only-messages")
public class Message {

    @Id
    private String _id; // MongoDB's default ID field
    private String userId;
    private String groupId;
    private String text;

    public Message() {
    }

    public Message(String _id, String userId, String groupId, String text) {
        this._id = _id;
        this.userId = userId;
        this.groupId = groupId;
        this.text = text;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
