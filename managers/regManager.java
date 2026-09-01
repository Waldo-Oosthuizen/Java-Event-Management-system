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
    public boolean registerStudent(Student student, Integer eventId) {
        // Find the event
        Event event = eventManger.getEventById(eventId);

        if (event == null) {
            System.out.println("Event not found");
            return false;
        }

        // Check if student is already registered
        if (student.getRegisteredE().contains(eventId) || student.getWaitlistedE().contains(eventId)){
            System.out.println("Already registered or added to waitlist");
            return false;
        }

        // Check if event's max capacity has not been reached
        if (event.getRegStudents().size() < event.getMaxStudents()){
            // Register student
            student.addRegistrationE(eventId);
            // Add student to event's registered student record
            event.addRegStudent(student);
            System.out.println("Student successfully registered.");
            return true;
        } 

        else {
            event.addToWaitlist(student);
            student.addToWaitlistedE(eventId);
            System.out.println("Event is full.");
            System.out.println("Student has been added to waitlist.");
            return true;
        }
     }
    
    // Cancel event registration
    public boolean cancelRegistration(Student student, Integer eventId) {

        // Find the event
        Event event = eventManger.getEventById(eventId);

        if (event == null) {
            System.out.println("Event not found");
            return false;
        }

        // Student is registered
        if (student.getRegisteredE().contains(eventId)) {

            // Remove registered status from student
            student.removeRegisteredEvent(eventId);

            // Remove registered student from event
            event.getRegStudents().remove(student);

            System.out.println(
                "Student registration has been cancelled."
            );
            
            // Auto-promote first waitlisted student
            Thread promoThread = new Thread(() -> {

                System.out.println("(THREAD STARTED) Notification ****");

                promoteWaitlist(event);

                System.out.println("(THREAD FINISHED) ****");
            });

            // Start thread
            promoThread.start();

            return true;
        }

        // Student is waitlisted
        else if (student.getWaitlistedE().contains(eventId)) {

            // Remove waitlisted status from student
            student.removeWaitlistedE(eventId);

            // Remove student from event waitlist
            event.getWaitlist().remove(student);

            System.out.println(
                "Student has been removed from the waitlist."
            );
            return true;
        }

        // Student has neither status
        else {

            System.out.println(
                "Student is not registered or waitlisted for this event."
            );
            return false;
        }
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

