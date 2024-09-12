package com.ng.fsa_server.membersOnly.dto;

public class MessageDTO {

    private String userId;
    private String userName;
    private String groupId;
    private String text;

    public MessageDTO(String userId, String userName, String groupId, String text) {
        this.userId = userId;
        this.userName = userName;
        this.groupId = groupId;
        this.text = text;
    }

    public MessageDTO() {
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
