package com.ng.fsa_server.membersOnly.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "members-only-users")
public class User {
    @Field(name = "id")
    @JsonProperty("id")
    private String customId;
    private String fullName;
    private String email;

    public User() {
    }

    public User(String customId, String fullName, String email) {
        this.customId = customId;
        this.fullName = fullName;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomId() {
        return customId;
    }

    public void setCustomId(String customId) {
        this.customId = customId;
    }
}
