package models;

import java.util.ArrayList;

  // Inherits from User class GeeksforGeeks (2017)
public class Student extends User {

    private Integer waitListedEvents;
    private ArrayList<Integer> registeredEvents;

    // Constructor
    public Student(Integer userId, String username, String email, Integer waitListedEvents){
        super(userId, username, email);
        registeredEvents = new ArrayList<>();
        this.waitListedEvents = waitListedEvents;
    }

    // Getters
    // Get Registered events
    public ArrayList<Integer> getRegisteredE(){
        return registeredEvents;
    }
    
    // Get waitlisted  events
    public Integer getWaitlistedE(){
        return waitListedEvents;
    }

    // Add methods
    // Add registered event
    public void addRegisteredEvent(Integer eventId) {
        registeredEvents.add(eventId);
    }

    // remove methods
    // Remove registered event
    public void removeRegisteredEvent(Integer eventId) {
        registeredEvents.remove(eventId);
    }
}
