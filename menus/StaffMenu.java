package menus;
// Imports
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import models.Event;
import models.Student;

import managers.EventManager;

import utils.InputValidator;
import utils.FileManager;


public class StaffMenu {
    // Event manager used by Student Menu as well
    private EventManager eventManager;

    Scanner input = new Scanner(System.in);

    // Constructor
    public StaffMenu(EventManager eventManager){
        this.eventManager = eventManager;
    }

    public void displayMenu(){

        boolean running = true;

        while(running){
            System.out.println("----------- Staff Menu -----------");
            System.out.println("1. Create Event");
            System.out.println("2. View Events");
            System.out.println("3. Update Event");
            System.out.println("4. Cancel Event");
            System.out.println("5. View Participants"); 
            System.out.println("6. View wait list"); 
            System.out.println("7. Search Events");
            System.out.println("8. Sort Events");
            System.out.println("9. Save Data");
            System.out.println("10. Back");

            // User choice
            System.out.println("Enter Choice: ");
            int choice = InputValidator.intCheck(input);

            switch (choice) {
                // 1. Create Event
                case 1:
                    System.out.println("Enter Event ID: ");
                    int eventId = InputValidator.positiveIntCheck(input);

                    System.out.println("Enter Event Name: ");
                    String eventName = InputValidator.emptyStringCheck(input);

                    System.out.println("Enter Event Date (YYYY-MM-DD): ");
                    LocalDate eventDate = InputValidator.dateCheck(input);

                    System.out.println("Enter Event Time (HH:mm): ");
                    LocalTime eventTime = InputValidator.timeCheck(input);

                    System.out.println("Enter Event Location: ");
                    String eventLocation = InputValidator.emptyStringCheck(input);

                    System.out.println("Enter Maximum Students: ");
                    int maxStudents = InputValidator.positiveIntCheck(input);

                    eventManager.createEvent(eventId, eventName, eventDate, eventTime, eventLocation, maxStudents);
                    break;

                // 2. View Events
                case 2:
                    System.out.println("------- Viewing Events -------"); 
                     
                    eventManager.listAllEvents();
                    break;

                // 3. Update Events
                case 3:
                    System.out.println("------- Updating Event -------");
                    
                    System.out.println("Enter Event ID to update: ");
                    int eventIdUpdate = InputValidator.positiveIntCheck(input);

                    System.out.println("Enter New Event Name: ");
                    String newEventName = InputValidator.emptyStringCheck(input);

                    System.out.println("Enter New Event Date (YYYY-MM-DD): ");
                    LocalDate newEventDate = InputValidator.dateCheck(input);

                    System.out.println("Enter New Event Time (HH:mm): ");
                    LocalTime newEventTime = InputValidator.timeCheck(input);

                    System.out.println("Enter New Event Location: ");
                    String newEventLocation = InputValidator.emptyStringCheck(input);

                    System.out.println("Enter New Maximum Students: ");
                    int newMaxStudents = InputValidator.positiveIntCheck(input);
              
                    // Update event
                    eventManager.updateEvent(eventIdUpdate, 
                        newEventName, 
                        newEventDate, 
                        newEventTime,
                        newEventLocation,
                        newMaxStudents
                    );

                    break;

                // 4. Cancel Events
                case 4:
                    System.out.println("Cancelling Event");

                    System.out.println("Enter Event ID to cancel: ");
                    int cancelId = InputValidator.positiveIntCheck(input);

                    eventManager.cancelEvent(cancelId);
                    
                    break;

                // 5. View Participants
                case 5:
                    System.out.println("------ Viewing Participants ------");

                    System.out.println("Enter Event ID: ");
                    int idInput = InputValidator.positiveIntCheck(input);

                    Event event = eventManager.getEventById(idInput);

                    // Check if event was found
                    if (event == null) {
                        System.out.println("Event not found");
                        break;
                    }

                    if (event.getRegStudents().isEmpty()){
                        System.out.println("No students have registered for this event yet");
                    }
                    else {
                        System.out.println("Participants: ");

                        for (Student student: event.getRegStudents()){
                            System.out.println(
                                "ID: " + student.getId() + " | Name: " + student.getUsername()
                            );
                        }
                    }

                    break;     


                // 6. View wait list
                case 6:
                    System.out.println("------ Viewing wait list ------");

                    System.out.println("Enter Event ID: ");
                    int waitlistId = InputValidator.positiveIntCheck(input);

                    Event waitlistedEvent = eventManager.getEventById(waitlistId);

                    // Check if event was found
                    if (waitlistedEvent == null) {
                        System.out.println("Event not found");
                        break;
                    }

                    if (waitlistedEvent.getWaitlist().isEmpty()){
                        System.out.println("No students are waitlisted for this event yet");
                    }
                    else {
                        System.out.println("Waitlisted Students: ");

                        for (Student student: waitlistedEvent.getWaitlist()){
                            System.out.println(
                                "ID: " + student.getId() + " | Name: " + student.getUsername()
                            );
                        }
                    }

                    
                    break;   

                // 7. Search Events
                case 7:
                    System.out.println("----- Searching Event -----");
                    System.out.println("1. Search by Name");
                    System.out.println("2. Search by Date");

                    System.out.println("Enter Choice: ");
                    int searchChoice = InputValidator.intCheck(input);


                    switch (searchChoice) {
                        // Search by name

                        case 1: 
                        System.out.println("----- Searching Event By Name -----");
                        System.out.print("Enter Event Name: ");
                        String searchName = InputValidator.emptyStringCheck(input);

                        eventManager.searchByName(searchName);

                        break;
                        // Search by date
                        case 2: 
                            System.out.println("----- Searching Event By Date -----");
                            System.out.print("Enter Event Date (YYYY-MM-DD)");
                            LocalDate searchDate = InputValidator.dateCheck(input);

                        eventManager.searchByDate(searchDate);

                        break;

                        default:
                            System.out.println("Invalid Selection");
                            break;
                    }
                    break;  

                // 8. Sort Events
                case 8:
                    System.out.println("----- Sorting Events -----");
                    System.out.println("1. Sort by Name");
                    System.out.println("2. Sort by Date");

                    System.out.println("Enter Choice: ");
                    int sortChoice = InputValidator.intCheck(input);


                    switch (sortChoice) {

                        // Sort by name
                        case 1: 
                        System.out.println("----- Sorting Event By Name -----");

                        eventManager.sortByName();

                        break;

                        case 2: 
                        System.out.println("----- Sorting Event By Date -----");

                        eventManager.sortByDate();

                        break;

                        default:
                            System.out.println("Invalid Selection");
                            break;
                    }
                    break;  
           
                // 9. Save
                case 9:
                    System.out.println("Saving...");
                    // Store events
                    FileManager.saveEvents(eventManager);
                    
                    break;
                    
                // 10. Exit
                case 10:
                    System.out.println("Returning to main menu...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;
                    

            }
        }
    }



   
    
   


}

