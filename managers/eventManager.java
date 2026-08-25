package managers;

import models.Event;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;


// import models.Student;
public class EventManager {
    // List to store events
    private List<Event> events;

    // Constructor to initialize the storage list
    public EventManager() {
        this.events = new ArrayList<>();
    }

     // Create events
     public void createEvent(     
        Integer eventId, 
        String eventName, 
        LocalDate eventDate, 
        LocalTime eventTime, 
        String location, 
        Integer maxStudents)
        {

            // Create new event using the event constructor
            Event newEvent = new Event(eventId, eventName, eventDate,eventTime,
                location, maxStudents);

            events.add(newEvent);
            System.out.println("Successfully created event: " + eventName);

        }

    // View all events
    public void listAllEvents() {
        if (events.isEmpty()) {
            System.out.println("No events found.");
            return;
        }

        for (Event event : events) {
            System.out.println(event);
        }
    }

    // Get event by its ID
    public Event getEventById(Integer inputId) {
        System.out.println("--- Searching for event with the ID: " + inputId);
        for (Event event : events) {
            if (inputId == event.getEventId()){
                System.out.println("--- Found Event! ---");
                System.out.println(event);
                return event;
            }
        }
        return null;
    }
    
    // Update event details
    public void updateEvent(
        Integer eventId,
        String eventName,
        LocalDate eventDate,
        LocalTime eventTime,
        String location,
        Integer maxStudents
    ) {
        // Check for event
        Event event = getEventById(eventId);

        if (event == null){
            System.out.println("Event not found");
            return;
        }

        event.setEventName(eventName);
        event.setEventDate(eventDate);
        event.setEventTime(eventTime);
        event.setLocation(location);
        event.setMaxStudents(maxStudents);

    System.out.println("Event successfully updated.");
    }

    // Cancel events
    public void cancelEvent(int eventId) {

    Event event = getEventById(eventId);

    if (event == null) {
        System.out.println("Event not found.");
        return;
    }

    events.remove(event);

    System.out.println("Event with id: " + eventId + " successfully cancelled.");
}

    
    // Register Students
    // private ArrayList<Student> registeredStudents;
    // Waitlist
    // private Queue<Student> waitlist;
   



}
