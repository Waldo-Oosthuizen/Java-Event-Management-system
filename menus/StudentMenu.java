package menus;
// Imports
import java.util.Scanner;
import managers.EventManager;
import managers.RegManager;
import models.Student;

public class StudentMenu {
    
    private Student alice = new Student(
        101,
        "Alice",
        "alice@gmail.com",
        0
    );

    private Student bob = new Student(
        102,
        "Bob",
        "bob@gmail.com",
        0
    );

    private Student charlie = new Student(
        103,
        "Charlie",
        "charlie@gmail.com",
        0
    );

    // Registration Manager
    private RegManager regManager;
    // Event manager 
    private EventManager eventManager;

    // Scanner for input
    private Scanner input = new Scanner(System.in);

    // Constructor
    public StudentMenu(EventManager eventManager){
        this.eventManager = eventManager;
        this.regManager = new RegManager(eventManager);
    }

    // Students Selection menu
    private Student selectStudent() {
            System.out.println("#### Student Menu ####");
            System.out.println("1. Alice");
            System.out.println("2. Bob");
            System.out.println("3. Charlie");
            System.out.println("4. Back");
            // Clear next Enter Key
            int choice = input.nextInt();
            input.nextLine();

            switch(choice) {
                case 1:
                    return alice;
                
                case 2:
                    return bob;

                case 3: 
                    return charlie;

                case 4: 
                    return null;

                default: 
                    System.out.println("Invalid Selection");
                    return null;
            }


    }
    // Display menus
    public void displayMenu(){
        // Current Student
        Student currStudent = selectStudent();


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
            // Clear next Enter Key
            int choice = input.nextInt();
            input.nextLine();

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
                    int regId = input.nextInt();
                    input.nextLine();

                regManager.registerStudent(student, regId);

                System.out.println(student.getRegisteredE());
                    break;

                // 3. Cancel Registration
                case 3:
                    System.out.println("Choice 3 Selected");
                    break;

                // 4. Check Registration Status
                case 4:
                    System.out.println("Choice 4 Selected");
                    break;

                // 5. Exit Student Menu
                case 5:
                    System.out.println("Choice 5 Selected, goodbye");
                    running = false;
                    break;
            }
        }
    }

    
        
    


}

