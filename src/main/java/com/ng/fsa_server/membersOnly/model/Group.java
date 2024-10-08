package com.ng.fsa_server.membersOnly.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "members-only-groups")
public class Group {

    @Id
    private String _id;

    private String name;
    private String ownerId;
    @Field(name = "members")
    private List<String> membersIds = new ArrayList<>();

    public Group() {
    }

    public Group(String name, String ownerId) {
        this.name = name;
        this.ownerId = ownerId;
        this.membersIds.add(ownerId);
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getMembersIds() {
        return membersIds;
    }

    public void setMembersIds(List<String> membersIds) {
        this.membersIds = membersIds;
    }
}
