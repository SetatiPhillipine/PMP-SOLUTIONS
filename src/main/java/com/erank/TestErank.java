package com.erank;

import com.erank.controllers.AuthController;
import com.erank.controllers.AdminController;
import com.erank.models.User;
import com.erank.services.QueueService;
import com.erank.services.TripService;
import com.erank.services.PassengerService;

import java.util.UUID;

public class TestErank {
    public static void main(String[] args) {
        System.out.println("E-RANK System Test");
        System.out.println("=========================================");
        
        System.out.println("TESTING AUTHENTICATION (Sections 2.1 & 2.2)");
        System.out.println("-----------------------------------------");
        AuthController auth = new AuthController();
        
        auth.register("John Doe", "0821234567", "driver@erank.com", "password123", "driver");
        auth.register("Jane Smith", "0839876543", "passenger@erank.com", "pass123", "passenger");
        
        User driver = auth.login("driver@erank.com", "password123");
        System.out.println("Logged in as: " + driver.getFullName() + " (" + driver.getRole() + ")");
        
        System.out.println();
        System.out.println("TESTING QUEUE MANAGEMENT (Section 1.3 & 1.1)");
        System.out.println("-----------------------------------------");
        QueueService queueService = new QueueService();
        int position = queueService.joinQueue(driver, "ROUTE_001");
        System.out.println("Driver queue position: " + position);
        
        queueService.callNextTaxi("ROUTE_001");
        
        System.out.println();
        System.out.println("TESTING TRIP MANAGEMENT (Section 1.4 & 1.5)");
        System.out.println("-----------------------------------------");
        TripService tripService = new TripService();
        UUID tripId = UUID.randomUUID();
        tripService.createTrip(driver.getUserId(), "ROUTE_001", 150.00, 14);
        tripService.completeTrip(tripId);
        
        System.out.println();
        System.out.println("TESTING OWNER MONITORING (Section 1.5)");
        System.out.println("-----------------------------------------");
        tripService.getOwnerSummary(UUID.randomUUID());
        
        System.out.println();
        System.out.println("TESTING PASSENGER REGISTRATION (Section 2.4 & FR-01)");
        System.out.println("-----------------------------------------");
        PassengerService passengerService = new PassengerService();
        passengerService.registerPassenger("Jane Smith", "0821112222", tripId, "ROUTE_001", 5);
        
        System.out.println();
        System.out.println("=========================================");
        System.out.println("All tests completed successfully.");
    }
}
