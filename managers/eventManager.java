package managers;

import models.Event;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Comparator;


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
            // Check for duplicate
            if (getEventById(eventId) != null) {
                System.out.println("Event ID already exists.");
                return;
            }

            // Validate that max students are not 0 or less
            if (maxStudents <= 0) {
                System.out.println("Maximum students must be greater than 0.");
                return;
            }
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
            System.out.println("-----------------------------");
            System.out.println(event);
            System.out.println("-----------------------------");
        }
    }

    // Get event by its ID
    public Event getEventById(Integer inputId) {
        // System.out.println("--- Searching for event with the ID: " + inputId);
        for (Event event : events) {
            if (inputId.equals(event.getEventId())){
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
        Integer maxStudents){

        // Check for event
        Event event = getEventById(eventId);
        
        // Make sure max students is not set to 0 or less
        if (maxStudents <= 0) {
            System.out.println("Maximum students must be greater than 0.");
        return;
}


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

    // Search by name
    public void searchByName(String searchTerm) {

        boolean found = false;

        for (Event event : events) {

            if (event.getEventName().toLowerCase().contains(searchTerm.toLowerCase())){
                System.out.println("--- Found Event! ---");
                System.out.println(event);

                found = true;
            }
        }
        
        if (!found){
            System.out.println("--- Event Could Not Be Found ----");
        }

    }

    // Search by date
    public void searchByDate (LocalDate dateSearch) {

        boolean found = false;

        for (Event event : events) {

            if (event.getEventDate().equals(dateSearch)){
                System.out.println("--- Found Event! ---");
                System.out.println(event);

                found = true;
            }
        }

        if (!found) {
             System.out.println("xxx Event Not Found! xxx");
        }

    }
    
    // Sort by name. Oracle (2019)
    public void sortByName() {
        // Sort events alphabetically by comparing each event's get name value
        events.sort(Comparator.comparing(Event::getEventName));

        System.out.println("--- Events Sorted by Name ---");

        listAllEvents();

    }
    
    // Sort by date
    public void sortByDate() {
        // Sort events numerically by comparing each event's get date value
        events.sort(Comparator.comparing(Event::getEventDate));

        System.out.println("--- Events Sorted by Date ---");

        listAllEvents();
    }

    // Get all events
    public List<Event> getEvents() {
        return events;
    }

    // add event - Used in file manager
    public void addEvent(Event event) {
        events.add(event);
    }
}
