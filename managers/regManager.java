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

        // Add registered student
        student.addRegistrationE(eventId);
        System.out.println("Student successfully registered.");

     }

    // Cancel event registration

    // View registration status 

}
