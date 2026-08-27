
import menus.StaffMenu;
import menus.StudentMenu;
// import models.Student;
import managers.EventManager;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
  
    // Student student = new Student(1, "Waldo", "waldo@gmail.com", 1);
    
    public static void main(String[] args){

        EventManager eventManager = new EventManager();

        // Student menu
        StudentMenu studentMenu = new StudentMenu(eventManager);

        // Staff menu
        StaffMenu staffMenu = new StaffMenu(eventManager);
        
        
        // Events for testing
        eventManager.createEvent(
            1,
            "Java Practice",
            LocalDate.of(2026, 9, 15),
            LocalTime.of(14, 30),
            "Computer Lab",
            20
        );

        eventManager.createEvent(
            2,
            "Python Workshop",
            LocalDate.of(2026, 9, 18),
            LocalTime.of(10, 0),
            "Room 101",
            15
        );

        eventManager.createEvent(
            3,
            "Advanced Java Workshop",
            LocalDate.of(2026, 9, 22),
            LocalTime.of(13, 0),
            "Computer Lab",
            25
        );

        eventManager.createEvent(
            4,
            "Database Fundamentals",
            LocalDate.of(2026, 9, 25),
            LocalTime.of(9, 30),
            "Room 205",
            30
        );

        eventManager.createEvent(
            5,
            "Java Fundamentals",
            LocalDate.of(2026, 10, 1),
            LocalTime.of(14, 0),
            "Lecture Hall",
            40
        );

        // Student for testing
        // Student student = new Student(
        //     1,
        //     "Waldo",
        //     "waldo@gmail.com",
        //     1
        // );

        // RegManager registrationManager =
        // new RegManager(eventManager);

        // registrationManager.registerStudent(student, 1);

        // System.out.println(student.getRegisteredE());

        // Main menu loop
        boolean running = true;
        while (running) {
            System.out.println("#### Main Menu ####");
            System.out.println("1. Student");
            System.out.println("2. Staff");
            System.out.println("3. Exit");
            System.out.println("Enter Choice");

            int choice = input.nextInt();
            

            switch (choice) {
                case 1:
                    studentMenu.displayMenu();
                    break;
                case 2:
                    staffMenu.displayMenu();
                    break;
                case 3:
                    System.out.println("Goodbye...");
                    running = false;
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
