package com.erank.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class QueueEntry {
    private UUID queueId;
    private User driver;
    private String routeId;
    private int position;
    private String status;
    private int priority;
    private LocalDateTime joinedAt;
    private LocalDateTime departedAt;
    
    public QueueEntry(User driver, String routeId) {
        this.queueId = UUID.randomUUID();
        this.driver = driver;
        this.routeId = routeId;
        this.status = "waiting";
        this.priority = 0;
        this.joinedAt = LocalDateTime.now();
    }
    
    public UUID getQueueId() { return queueId; }
    public void setQueueId(UUID queueId) { this.queueId = queueId; }
    
    public User getDriver() { return driver; }
    public void setDriver(User driver) { this.driver = driver; }
    
    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }
    
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    
    public LocalDateTime getJoinedAt() { return joinedAt; }
    public void setJoinedAt(LocalDateTime joinedAt) { this.joinedAt = joinedAt; }
    
    public LocalDateTime getDepartedAt() { return departedAt; }
    public void setDepartedAt(LocalDateTime departedAt) { this.departedAt = departedAt; }
}
