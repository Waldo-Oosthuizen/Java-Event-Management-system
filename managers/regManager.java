package managers;

import models.Student;
import models.Event;


public class RegManager {

    // Use event manager to find event
    private EventManager eventManger;

    // Constructor
    public RegManager(EventManager eventManager) {
        this.eventManger = eventManager;
    }

     // Register for events
     public void registerStudent(Student student, Integer eventId) {
        // Find the event
        Event event = eventManger.getEventById(eventId);

        if (event == null) {
            System.out.println("Event not found");
            return;
        }

        // Check if student is already registered
        if (student.getRegisteredE().contains(eventId)){
            System.out.println("Already registered or added to waitlist");
            return;
        }

        // Check if event's max capacity has not been reached
        if (event.getRegStudents().size() < event.getMaxStudents()){
            // Register student
            student.addRegistrationE(eventId);
            // Add student to event's registered student record
            event.addRegStudent(student);
            System.out.println("Student successfully registered.");
        } 

        else {
            event.addToWaitlist(student);
            student.addToWaitlistedE(eventId);
            System.out.println("Event is full.");
            System.out.println("Student has been added to waitlist.");
        }
     }
    // Cancel event registration

    // View registration status 

}

