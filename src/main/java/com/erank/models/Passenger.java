package com.erank.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Passenger {
    private UUID passengerId;
    private String fullName;
    private String emergencyContact;
    private UUID tripId;
    private String routeId;
    private int seatNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime createdAt;
    
    public Passenger(String fullName, String emergencyContact, UUID tripId, String routeId, int seatNumber) {
        this.passengerId = UUID.randomUUID();
        this.fullName = fullName;
        this.emergencyContact = emergencyContact;
        this.tripId = tripId;
        this.routeId = routeId;
        this.seatNumber = seatNumber;
        this.registeredAt = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
    }
    
    public UUID getPassengerId() { return passengerId; }
    public void setPassengerId(UUID passengerId) { this.passengerId = passengerId; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }
    
    public UUID getTripId() { return tripId; }
    public void setTripId(UUID tripId) { this.tripId = tripId; }
    
    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }
    
    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }
    
    public LocalDateTime getRegisteredAt() { return registeredAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
