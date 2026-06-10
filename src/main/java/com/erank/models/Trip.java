package com.erank.models;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.UUID;

public class Trip {
    private UUID tripId;
    private UUID driverId;
    private String routeId;
    private double fareAmount;
    private int passengerCount;
    private String status;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    
    public Trip(UUID driverId, String routeId, double fareAmount, int passengerCount) {
        this.tripId = UUID.randomUUID();
        this.driverId = driverId;
        this.routeId = routeId;
        this.fareAmount = fareAmount;
        this.passengerCount = passengerCount;
        this.status = "active";
        this.departureTime = LocalDateTime.now();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public UUID getTripId() { return tripId; }
    public void setTripId(UUID tripId) { this.tripId = tripId; }
    
    public UUID getDriverId() { return driverId; }
    public void setDriverId(UUID driverId) { this.driverId = driverId; }
    
    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }
    
    public double getFareAmount() { return fareAmount; }
    public void setFareAmount(double fareAmount) { this.fareAmount = fareAmount; }
    
    public int getPassengerCount() { return passengerCount; }
    public void setPassengerCount(int passengerCount) { this.passengerCount = passengerCount; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
    
    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { 
        this.arrivalTime = arrivalTime;
        this.updatedAt = LocalDateTime.now();
    }
    
    public long getDurationMinutes() {
        if (departureTime != null && arrivalTime != null) {
            return Duration.between(departureTime, arrivalTime).toMinutes();
        }
        return 0;
    }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
