package menus;
// Imports
import java.util.Scanner;
import managers.EventManager;
import managers.RegManager;
import managers.StudentManager;

import models.Student;
import utils.InputValidator;
import utils.FileManager;

public class StudentMenu {
    
    
    // Registration Manager
    private RegManager regManager;
    // Event manager 
    private EventManager eventManager;
    // Student manager
    private StudentManager studentManager;
    // Scanner for input
    private Scanner input = new Scanner(System.in);

    // Constructor
    public StudentMenu(EventManager eventManager, StudentManager studentManager){
        this.eventManager = eventManager;
        this.studentManager = studentManager;
        this.regManager = new RegManager(eventManager);
        
    }

    // Students Selection menu
    private Student selectStudent() {
            System.out.println("#### Student Menu ####");
            System.out.println("1. Harry");
            System.out.println("2. Ron");
            System.out.println("3. Hermione");
            System.out.println("4. Back");
            // User input
            int choice = InputValidator.intCheck(input);

            switch(choice) {
                case 1:
                    return studentManager.getStudentById(101);
                
                case 2:
                    return studentManager.getStudentById(102);

                case 3: 
                    return studentManager.getStudentById(103);

                case 4: 
                    return null;

                default: 
                    System.out.println("Invalid Selection");
                    return null;
            }

    }
    // Display menu
    public void displayMenu(){
        // Current Student
        Student currStudent = selectStudent();

        // If student has not been chosen
        if(currStudent == null){
            return;
        }
        // Display student options menu
        studentOptions(currStudent);
    }

    public void studentOptions(Student student) {
        // Bool for while loop
        boolean running = true;
        // keep running while true
        while(running){
            System.out.println("#### Student Menu ####");
            System.out.println("Current Student: " + student.getUsername());
            System.out.println("Student ID: " + student.getId());

            System.out.println("1. View Events");
            System.out.println("2. Register for Event");
            System.out.println("3. Cancel Registration");
            System.out.println("4. Check Registration Status");
            System.out.println("5. Back");
            // User input
            int choice = InputValidator.intCheck(input);

            switch (choice) {
                // 1. View Events
                case 1:
                    System.out.println("------- Viewing Events -------"); 
                    eventManager.listAllEvents();
                    break;

                // 2. Register for Event
                case 2:
                    System.out.println("Registering Student....");

                    System.out.println("Enter Event ID: ");
                    int regId = InputValidator.positiveIntCheck(input);
                 
                // Registration manager
                regManager.registerStudent(student, regId);
                // Store to file
                FileManager.saveStudents(studentManager);
                FileManager.saveEvents(eventManager);
                System.out.println(student.getRegisteredE());
                    break;

                // 3. Cancel Registration
                case 3:
                    System.out.println("----- Cancel Registration -----");

                    System.out.println("Enter Event ID: ");
                    int eventId = InputValidator.positiveIntCheck(input);
                    // Registration manager
                    regManager.cancelRegistration(student, eventId);
                    // Store to file
                    regManager.cancelRegistration(student, eventId);
                    break;

                // 4. Check Registration Status
                case 4:
                    System.out.println("----- Registration Status -----");

                    System.out.println("Student: " + student.getUsername());
                    System.out.println("Student ID: " + student.getId());

                    System.out.println("Registered Events: " + "ID: " + student.getRegisteredE());
                    System.out.println("Waitlisted Events: " + student.getWaitlistedE());
                    
                    break;

                // 5. Exit Student Menu
                case 5:
                    System.out.println("Choice 5 Selected, goodbye");
                    running = false;
                    break;
                
                default:
                    System.out.println("Selection was invalid");
            }
        }
    }

    
        
    


}

