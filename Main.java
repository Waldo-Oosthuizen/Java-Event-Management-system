import java.time.LocalDate;
import java.time.LocalTime;

import models.Event;
import models.Staff;
import models.Student;

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


        Event event = new Event(1
            , "Java Practice", 
            LocalDate.of(2026,9,15), 
            LocalTime.of(14,30), 
            "Computer Labs Class", 
            20);

            System.out.println("Event ID: " + event.getEventId());
            System.out.println("Name: " + event.getEventName());
            System.out.println("Date: " + event.getEventDate());
            System.out.println("Time: " + event.getEventTime());
            System.out.println("Location: " + event.getLocation());
            System.out.println("Max Students: " + event.getMaxStudents());

            event.getRegStudents().add(student);

            System.out.println(
        event.getRegStudents().get(0).getUsername()
);
    }
    
}
