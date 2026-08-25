package menus;
// Imports
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import managers.EventManager;

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
            System.out.println("5. View Participants"); // TO DO
            System.out.println("6. View Waitlist"); // TO DO
            System.out.println("7. Search Events");
            System.out.println("8. Sort Events");
            System.out.println("9. Back");

            // User choice
            System.out.println("Enter Choice: ");
            int choice = input.nextInt();

            switch (choice) {
                // 1. Create Event
                case 1:
                    System.out.println("------- Creating Event -------");

                    System.out.println("Enter Event ID: ");
                    int eventId = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Event Name: ");
                    String eventName = input.nextLine();
               
                    System.out.println("Enter Event Date (YYYY-MM-DD): ");
                    LocalDate eventDate = LocalDate.parse(input.nextLine());

                    System.out.println("Enter Event Time: ");
                    LocalTime eventTime = LocalTime.parse(input.nextLine());

                    System.out.println("Enter Event Location: ");
                    String eventLocation = input.nextLine();

                    System.out.print("Enter Maximum Students: ");
                    int maxStudents = input.nextInt();
                    input.nextLine();

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
                    int eventIdUpdate = input.nextInt();
                    input.nextLine();
                    

                    System.out.println("Enter New Event Name: ");
                    String newEventName = input.nextLine();
               
                    System.out.println("Enter New Event Date (YYYY-MM-DD): ");
                    LocalDate newEventDate = LocalDate.parse(input.nextLine());

                    System.out.println("Enter New New Event Time: ");
                    LocalTime newEventTime = LocalTime.parse(input.nextLine());

                    System.out.println("Enter New Event Location: ");
                    String newEventLocation = input.nextLine();

                    System.out.print("Enter New Maximum Students: ");
                    int newMaxStudents = input.nextInt();
                    input.nextLine();
              
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
                    int cancelId = input.nextInt();
                    input.nextLine();

                    eventManager.cancelEvent(cancelId);
                    
                    break;

                // 5. View Participants
                case 5:
                    System.out.println("------ Viewing Participants");
                    
                    break;     


                // 6. View Waitlist
                case 6:
                    System.out.println("Choice 4 Selected, goodbye");
                    
                    break;   

                // 7. Search Events
                case 7:
                    System.out.println("Choice 4 Selected, goodbye");
                    
                    break;  

                // 8. Sort Events
                case 8:
                    System.out.println("Choice 4 Selected, goodbye");
           
                    break;
                    
                // 9. Exit
                case 9:
                    System.out.println("Choice 4 Selected, goodbye");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;
                    

            }
        }
    }



   
    
   


}

