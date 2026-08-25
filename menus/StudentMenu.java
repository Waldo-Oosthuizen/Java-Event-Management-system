package menus;
// Imports
import java.util.Scanner;
import managers.EventManager;

public class StudentMenu {

    // Event manager used by Staff Menu as well
    EventManager eventManager;
    // Constructor
    public StudentMenu(EventManager eventManager){
        this.eventManager = eventManager;
    }
    // Scanner for input
    Scanner input = new Scanner(System.in);
        // Display menu method
        public void displayMenu(){
        // Bool for while loop
        boolean running = true;
        // keep running while true
        while(running){
            System.out.println("#### Student Menu ####");
            System.out.println("1. View Events");
            System.out.println("2. Register for Event");
            System.out.println("3. Cancel Registration");
            System.out.println("4. Check Registration Status");
            System.out.println("5. Back");
            // Clear next Enter Key
            int choice = input.nextInt();

            switch (choice) {
                // 1. View Events
                case 1:
                    System.out.println("------- Viewing Events -------"); 
                    eventManager.listAllEvents();
                    break;

                // 2. Register for Event
                case 2:
                    System.out.println("Choice 2 Selected");
                    break;

                // 3. Cancel Registration
                case 3:
                    System.out.println("Choice 3 Selected");
                    break;

                // 4. Check Registration Status
                case 4:
                    System.out.println("Choice 3 Selected");
                    break;

                // 5. Exit Student Menu
                case 5:
                    System.out.println("Choice 4 Selected, goodbye");
                    running = false;
                    break;
            }
        }
        }

    
        
    


}

