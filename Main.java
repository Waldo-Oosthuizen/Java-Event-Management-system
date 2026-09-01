
import menus.StaffMenu;
import menus.StudentMenu;

import managers.EventManager;
import managers.StudentManager;

import utils.FileManager;
import utils.InputValidator;


import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args){
        // Event manager
        EventManager eventManager = new EventManager();

        // Student manager
        StudentManager studentManager = new StudentManager();

        // Load events from file
        FileManager.loadEvents(eventManager);
        
        // Load students from file
        FileManager.loadStudents(studentManager, eventManager);
        // Student menu
        StudentMenu studentMenu = new StudentMenu(eventManager, studentManager);

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
              
                // Save all data before exiting
                FileManager.saveEvents(eventManager);
                FileManager.saveStudents(studentManager);
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



