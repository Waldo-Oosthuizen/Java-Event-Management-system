package models;

import java.util.ArrayList;

  // Inherits from User class GeeksforGeeks (2017)
public class Student extends User {

    private ArrayList<Integer> waitListedEvents;
    private ArrayList<Integer> registeredEvents;

    // Constructor
    public Student(Integer userId, String username, String email){
        super(userId, username, email);
        registeredEvents = new ArrayList<>();
        this.waitListedEvents = new ArrayList<>();
    }

    // Getters

    // Get Registered events
    public ArrayList<Integer> getRegisteredE(){
        return registeredEvents;
    }
    
    // Get waitlisted  events
    public ArrayList<Integer> getWaitlistedE(){
        return waitListedEvents;
    }


    // Add registered event
    public void addRegistrationE(Integer eventId) {
        registeredEvents.add(eventId);
    }

    // Add waitlisted event
    public void addToWaitlistedE(Integer eventId) {
        waitListedEvents.add(eventId);
    }
    // Remove registered event
    public void removeRegisteredEvent(Integer eventId) {
        registeredEvents.remove(eventId);
    }

}
