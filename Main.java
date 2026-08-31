
import menus.StaffMenu;
import menus.StudentMenu;

import managers.EventManager;
import utils.FileManager;
import utils.InputValidator;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
  
    // Student student = new Student(1, "Waldo", "waldo@gmail.com", 1);
    
    public static void main(String[] args){
        // Event manager
        EventManager eventManager = new EventManager();

        // Load events from file
        FileManager.loadEvents(eventManager);
        
        // Student menu
        StudentMenu studentMenu = new StudentMenu(eventManager);

        // Staff menu
        StaffMenu staffMenu = new StaffMenu(eventManager);
        
        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("#### Main Menu ####");
            System.out.println("1. Student");
            System.out.println("2. Staff");
            System.out.println("3. Exit");
            System.out.println("Enter Choice");
            // Validate with input validator
            int choice = InputValidator.intCheck(input);
            

            switch (choice) {
                case 1:
                    studentMenu.displayMenu();
                    break;
                case 2:
                    staffMenu.displayMenu();
                    break;
                case 3:
              
                // Store events
                FileManager.saveEvents(eventManager);
                // Exit program
                running = false;
                System.out.println("Goodbye...");
                
                break;

                default:
                    System.out.println("Invalid Selection");

            }

        }
        
    }
    
}



// Testing Code used in early stages of development

        // student.addRegistrationE(100);
        // student.addRegistrationE(200);
        // System.out.println("ID: " + student.getId());
        // System.out.println("Username: " + student.getUsername());
        // System.out.println("Email: " + student.getEmail());
        // System.out.println("Events IDs: " + student.getRegisteredE());

        // Staff staff = new Staff(2, "Admin", "admin@email.com", "Admin");

        // System.out.println("Staff Name: " + staff.getUsername());

        // EventManager manager = new EventManager();

        // manager.createEvent(1
        //     , "Java Practice", 
        //     LocalDate.of(2026,9,15), 
        //     LocalTime.of(14,30), 
        //     "Computer Labs Class", 
        //     20);

        // manager.createEvent(2
        //     , "Python Practice", 
        //     LocalDate.of(2026,9,15), 
        //     LocalTime.of(14,30), 
        //     "Computer Labs Class", 
        //     10);

        // // List all events
        // System.out.println("--- Current Events ---");
        // manager.listAllEvents();

        // // Find event by ID
        // manager.getEventById(1);

        // // Update event
        // manager.updateEvent(
        //     1,
        //     "Advanced Java Workshop",
        //     LocalDate.of(2026, 9, 20),
        //     LocalTime.of(15, 30),
        //     "Main Hall",
        //     30
        // );
        
        // // List all events after update
        // System.out.println("--- Current Events After update ---");
        // manager.listAllEvents();

        // // Cancel Event
        // manager.cancelEvent(1);
