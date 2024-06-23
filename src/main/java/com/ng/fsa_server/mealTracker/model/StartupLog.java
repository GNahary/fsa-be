package com.ng.fsa_server.mealTracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "startup_log")
public class StartupLog {

    @Id
    private String id;
    private int pid;
    private String hostname;
    private LocalDateTime startTime;
    private String startTimeLocal;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeLocal() {
        return startTimeLocal;
    }

    public void setStartTimeLocal(String startTimeLocal) {
        this.startTimeLocal = startTimeLocal;
    }
}

