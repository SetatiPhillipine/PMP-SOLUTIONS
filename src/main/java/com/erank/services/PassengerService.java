package com.erank.services;

import com.erank.models.Passenger;
import java.util.*;

public class PassengerService {
    
    private Map<UUID, Passenger> passengers = new HashMap<>();
    
    public Passenger registerPassenger(String fullName, String emergencyContact, 
                                        UUID tripId, String routeId, int seatNumber) {
        
        boolean seatAvailable = checkSeatAvailability(tripId, seatNumber);
        if (!seatAvailable) {
            System.out.println("Seat " + seatNumber + " is already taken on trip " + tripId);
            return null;
        }
        
        Passenger passenger = new Passenger(fullName, emergencyContact, tripId, routeId, seatNumber);
        passengers.put(passenger.getPassengerId(), passenger);
        
        System.out.println("Passenger registered:");
        System.out.println("Name: " + fullName);
        System.out.println("Trip: " + tripId);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Emergency contact: " + emergencyContact);
        
        return passenger;
    }
    
    private boolean checkSeatAvailability(UUID tripId, int seatNumber) {
        return true;
    }
    
    public Passenger getPassenger(UUID passengerId) {
        return passengers.get(passengerId);
    }
    
    public List<Passenger> getPassengersByTrip(UUID tripId) {
        return passengers.values().stream()
                .filter(p -> p.getTripId().equals(tripId))
                .toList();
    }
}
