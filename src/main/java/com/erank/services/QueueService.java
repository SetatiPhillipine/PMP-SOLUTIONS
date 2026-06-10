package com.erank.services;

import com.erank.models.QueueEntry;
import com.erank.models.User;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueService {
    
    private Map<String, Queue<QueueEntry>> routeQueues = new HashMap<>();
    private Map<String, Map<UUID, Integer>> queuePositions = new HashMap<>();
    
    public int joinQueue(User driver, String routeId) {
        QueueEntry entry = new QueueEntry(driver, routeId);
        
        routeQueues.putIfAbsent(routeId, new ConcurrentLinkedQueue<>());
        Queue<QueueEntry> queue = routeQueues.get(routeId);
        
        queue.add(entry);
        int position = queue.size();
        
        queuePositions.putIfAbsent(routeId, new HashMap<>());
        queuePositions.get(routeId).put(driver.getUserId(), position);
        
        System.out.println("Driver " + driver.getFullName() + " joined queue for route " + routeId);
        System.out.println("Position in queue: " + position);
        
        return position;
    }
    
    public int getQueuePosition(User driver, String routeId) {
        if (!queuePositions.containsKey(routeId)) {
            return -1;
        }
        return queuePositions.get(routeId).getOrDefault(driver.getUserId(), -1);
    }
    
    public QueueEntry callNextTaxi(String routeId) {
        if (!routeQueues.containsKey(routeId) || routeQueues.get(routeId).isEmpty()) {
            System.out.println("No drivers in queue for route: " + routeId);
            return null;
        }
        
        QueueEntry nextDriver = routeQueues.get(routeId).poll();
        nextDriver.setStatus("boarding");
        
        System.out.println("Calling next taxi:");
        System.out.println("Driver: " + nextDriver.getDriver().getFullName());
        System.out.println("Route: " + routeId);
        System.out.println("Status: BOARDING");
        
        return nextDriver;
    }
    
    public List<QueueEntry> getQueueList(String routeId) {
        if (!routeQueues.containsKey(routeId)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(routeQueues.get(routeId));
    }
    
    public void driverDeparts(UUID driverId, String routeId) {
        Queue<QueueEntry> queue = routeQueues.get(routeId);
        if (queue != null) {
            System.out.println("Driver " + driverId + " departed on route " + routeId);
        }
    }
}
