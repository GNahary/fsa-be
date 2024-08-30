package com.ng.fsa_server.membersOnly;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "members-only-users")
public class MembersOnlyUser {
    @Id
    private String _id;

    @Field(name = "id")
    @JsonProperty("id")
    private String customId;
    private String email;
    private String fullName;

    // Constructors
    public MembersOnlyUser() {
    }

    public MembersOnlyUser(String _id, String id, String email, String fullName) {
        this._id = _id;
        this.customId = id;
        this.email = email;
        this.fullName = fullName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
