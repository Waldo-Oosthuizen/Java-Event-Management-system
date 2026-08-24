package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;;

public class Event {
    // Event ID
    private Integer eventId;
    // Event Name
    private String eventName;
    // Event data (DD/MM/YYYY)
    private LocalDate eventDate;
    // Event Time (HH:mm)
    private LocalTime eventTime;
    // Location
    private String location;
    // Max Student
    private Integer maxStudents;
    // Registered Students
    private ArrayList<Student> registeredStudents;
    // Waitlist
    private Queue<Student> waitlist;
    

    // Constructor
    public Event(
        Integer eventId, 
        String eventName, 
        LocalDate eventDate, 
        LocalTime eventTime, 
        String location, 
        Integer maxStudents
    ) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.location = location;
        this.maxStudents = maxStudents;
        this.registeredStudents = new ArrayList<>();
        this.waitlist = new LinkedList<>();

    }

    // getters
    public Integer getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalTime getEventTime(){
        return eventTime;
    }

    public String getLocation(){
        return location;
    }

    public Integer getMaxStudents(){
        return maxStudents;
    }

    public ArrayList<Student> getRegStudents(){
        return registeredStudents;
    }

    public Queue<Student> getWaitlist() {
        return waitlist;
    }
}
