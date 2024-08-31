package com.ng.fsa_server.membersOnly.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "members-only-requests")
public class Request {

    @Id
    private String _id;

    @Field(name = "id")
    @JsonProperty("id")
    private String customId;
    private String groupId;
    private String userId;

    public Request() {
    }

    public Request(String customId, String groupId, String userId) {
        this.customId = customId;
        this.groupId = groupId;
        this.userId = userId;
    }

    public Request(String _id, String customId, String groupId, String userId) {
        this._id = _id;
        this.customId = customId;
        this.groupId = groupId;
        this.userId = userId;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
