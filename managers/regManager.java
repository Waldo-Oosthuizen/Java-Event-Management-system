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
     public void cancelRegistration(Student student, Integer eventId){

    // Find the event
        Event event = eventManger.getEventById(eventId);

        if (event == null) {
            System.out.println("Event not found");
            return;
        }

        // Check if student is already registered
        if (!student.getRegisteredE().contains(eventId)){
            System.out.println("Student is not registered for this event");
            return;
        }

        // Remove registered status from student
        student.removeRegisteredEvent(eventId);
        // Removed registered student from event
        event.getRegStudents().remove(student);

        System.out.println("Student registered for this event has been canceled");

        // Auto Promote first waitlisted student in background procesing thread (GeeksforGeeks, 2022)
        Thread promoThread = new Thread(() -> {

             System.out.println("(THREAD STARTED) Notification ****");

            promoteWaitlist(event);

            System.out.println("(THREAD FINISHED) ****");
        });

        // Start thread
        promoThread.start();
     }

     // Waitlist auto promotion method
     public void promoteWaitlist(Event event){
        // return if waitlist is empty
        if(event.getWaitlist().isEmpty()){
            return;
        }

        // Get the first student in the waitlist and remove the student from the queue
        Student student = event.getWaitlist().poll();

        // Promote student to registration status
        // update event
        event.addRegStudent(student);
        // update student
        student.addRegistrationE(event.getEventId());
        student.removeWaitlistedE(event.getEventId());

        // Notification
        System.out.println(
            student.getUsername() + " has been promoted from the waitlist.");
     }

}

