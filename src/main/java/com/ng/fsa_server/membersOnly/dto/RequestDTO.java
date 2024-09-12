package com.ng.fsa_server.membersOnly.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

public class RequestDTO {

    @Field(name = "id")
    @JsonProperty("id")
    private String customId;
    private String groupId;
    private String userId;
    private String userName;

    public RequestDTO() {
    }

    public RequestDTO(String customId, String groupId, String userId, String userName) {
        this.customId = customId;
        this.groupId = groupId;
        this.userId = userId;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
