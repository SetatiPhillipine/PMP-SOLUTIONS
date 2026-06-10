package com.erank.services;

import com.erank.models.Trip;
import com.erank.models.User;
import java.util.*;

public class TripService {
    
    private Map<UUID, Trip> trips = new HashMap<>();
    
    public Trip createTrip(UUID driverId, String routeId, double fareAmount, int passengerCount) {
        Trip trip = new Trip(driverId, routeId, fareAmount, passengerCount);
        trips.put(trip.getTripId(), trip);
        
        System.out.println("Trip created:");
        System.out.println("Trip ID: " + trip.getTripId());
        System.out.println("Driver: " + driverId);
        System.out.println("Fare: R" + fareAmount);
        System.out.println("Passengers: " + passengerCount);
        
        return trip;
    }
    
    public void completeTrip(UUID tripId) {
        Trip trip = trips.get(tripId);
        if (trip == null) {
            System.out.println("Trip not found: " + tripId);
            return;
        }
        
        trip.setStatus("completed");
        trip.setArrivalTime(java.time.LocalDateTime.now());
        
        System.out.println("Trip completed:");
        System.out.println("Trip ID: " + tripId);
        System.out.println("Duration: " + trip.getDurationMinutes() + " minutes");
        System.out.println("Total fare: R" + trip.getFareAmount());
    }
    
    public Map<String, Object> getOwnerSummary(UUID ownerId) {
        Map<String, Object> summary = new HashMap<>();
        
        List<Trip> ownerTrips = trips.values().stream()
                .filter(t -> t.getStatus().equals("completed"))
                .toList();
        
        int totalTrips = ownerTrips.size();
        double totalEarnings = ownerTrips.stream().mapToDouble(Trip::getFareAmount).sum();
        
        summary.put("totalTrips", totalTrips);
        summary.put("totalEarnings", totalEarnings);
        summary.put("activeTrips", trips.values().stream().filter(t -> t.getStatus().equals("active")).count());
        
        System.out.println("Owner Summary:");
        System.out.println("Total trips: " + totalTrips);
        System.out.println("Total earnings: R" + totalEarnings);
        
        return summary;
    }
}
