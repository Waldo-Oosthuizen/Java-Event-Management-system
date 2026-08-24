import java.time.LocalDate;
import java.time.LocalTime;


import models.Staff;
import models.Student;
import managers.EventManager;

public class Main {

    public static void main(String[] args){
        // Testing
        Student student = new Student(1, "Waldo", "waldo@gmail.com", 1);
        student.addRegisteredEvent(100);
        student.addRegisteredEvent(200);
        System.out.println("ID: " + student.getId());
        System.out.println("Username: " + student.getUsername());
        System.out.println("Email: " + student.getEmail());
        System.out.println("Events IDs: " + student.getRegisteredE());

        Staff staff = new Staff(2, "Admin", "admin@email.com", "Admin");

        System.out.println("Staff Name: " + staff.getUsername());

        EventManager manager = new EventManager();

        manager.createEvent(1
            , "Java Practice", 
            LocalDate.of(2026,9,15), 
            LocalTime.of(14,30), 
            "Computer Labs Class", 
            20);

        manager.createEvent(2
            , "Python Practice", 
            LocalDate.of(2026,9,15), 
            LocalTime.of(14,30), 
            "Computer Labs Class", 
            10);

        // List all events
        System.out.println("--- Current Events ---");
        manager.listAllEvents();

        // Find event by ID
        
        manager.getEventById(1);
    }
    
}
