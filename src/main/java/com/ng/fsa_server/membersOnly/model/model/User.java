package com.ng.fsa_server.membersOnly.model.model;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members-only-users")
public class User {
    private String fullName;
    private String email;

    public User() {
    }

    public User(String fullName, String email) {
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
}
