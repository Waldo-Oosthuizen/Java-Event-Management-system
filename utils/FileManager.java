package utils;
// Adapted from Gupta (2025) and Oracle (n.d)
import java.io.*;

import managers.EventManager;
import managers.StudentManager;
import models.Event;
import models.Student;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class FileManager {

    // Save events
    public static void saveEvents(EventManager eventManager) {
        try (FileOutputStream output = new FileOutputStream("data/events.txt")){
            // Capture each event's details
            for (Event event: eventManager.getEvents()) {
                String data = 
                event.getEventId() + "|" +
                event.getEventName() + "|" +
                event.getEventDate() + "|" +
                event.getEventTime() + "|" +
                event.getLocation() + "|" +
                event.getMaxStudents() + "\n";

            // Write to file
            output.write(data.getBytes());

            }
         // Success notification
         System.out.println("***Event data saved");
        }
        catch (IOException e){
            System.out.println("***Error saving events: " + e.getMessage());
        }
    }

    // Load events
    public static void loadEvents(EventManager eventManager){

        try (BufferedReader reader = new BufferedReader(new FileReader("data/events.txt")))
        {
            String line;

            while((line = reader.readLine()) != null){

                try {
                    // Split the data in the line into individual values
                    String[] data = line.split("\\|", -1);

                    // Enusre that the line contains all 6 of the event fields
                    if(data.length != 6){
                        System.out.println("Invalid event data: " + line);
                        continue;
                    }



                    // Storing the split line in integers
                    Integer eventId = Integer.parseInt(data[0]);
                    String eventName = data[1];
                    LocalDate eventDate = LocalDate.parse(data[2]);
                    LocalTime eventTime = LocalTime.parse(data[3]);
                    String location = data[4];
                    Integer maxStudents = Integer.parseInt(data[5]);

                    // Recreate the event
                    Event event = new Event(eventId, eventName, eventDate, eventTime, location, maxStudents);

                    // Add the event to the EventManager
                    eventManager.addEvent(event);

                } catch (NumberFormatException e){
                    System.out.println("Invalid number in event data: " + line);
                }
                catch (DateTimeParseException e){
                    System.out.println("Invalid date or time in event data: " + line);

                }

            }
        // Display success message
        System.out.println("The event data has successfully been loaded");

        }
        // No file
        catch (FileNotFoundException e) {

            System.out.println("File Not Found. continuing without data.");
        }
        // Couldn't load events
        catch (IOException e){
            System.out.println("Error loading events: " + e.getMessage());
        }
    }
    // Convert list to string 
    public static String listToStr(ArrayList<Integer> events){
        //Empty string
        String result = "";
        // Loop through events
        for (int i = 0; i < events.size(); i++){
            
            result += events.get(i);
            // seperate with commas
            if (i < events.size() - 1){
                result += ",";
            }
        }

        return result;
    }

    // Save students to file
    public static void saveStudents(StudentManager studentManager){

        // Create file if it does not exisit
        try (OutputStream output = new FileOutputStream("data/students.txt")){
            for (Student student : studentManager.getStudents()){
                // variable to store student's registered events
                String registeredEvents = listToStr(student.getRegisteredE());

                // variable to store student's waitlisted events
                String waitlistedEvents = listToStr(student.getWaitlistedE());

                String data = 
                        student.getId() + "|" +
                        student.getUsername() + "|" +
                        student.getEmail() + "|" +
                        registeredEvents + "|" +
                        waitlistedEvents + "\n";

                // write to file
                output.write(data.getBytes());
            }

            System.out.println("***Student Data saved.");
        }
        catch(IOException e) 
        {
            System.out.println("***Error saving students: " + e.getMessage());
        }     
    }

    // Load students from file
    public static void loadStudents(
        StudentManager studentManager,
        EventManager eventManager) {


            try (BufferedReader reader = new BufferedReader(new FileReader("data/students.txt"))){
                String line = "";

                // While there is something in line
                while ((line = reader.readLine()) != null){
                    String[] data = line.split("\\|", -1);
                    // Student ID
                    Integer studentId = Integer.parseInt(data[0]);

                    // Find existing student in studentManager
                    Student student = studentManager.getStudentById(studentId);

                    // Check if no student is found
                    if(student == null){
                        System.out.println("Student not found");
                        continue;
                    }

                    // Load the registered events if not empty
                    if(!data[3].isEmpty()){

                        String[] regEvents = data[3].split(",");

                        for (String eventId : regEvents){
                            Integer id = Integer.parseInt(eventId);
                            // Add event to student registration list
                            student.addRegistrationE(id);

                            // Add student to event's registration list
                            Event event = eventManager.getEventById(id);

                            if (event != null){
                                event.addRegStudent(student);
                            }
                        }
                    }

                    // Load the waitlisted events
                    if(!data[4].isEmpty()){

                        String[] waitlistedEvents = data[4].split(",");

                        for (String eventID : waitlistedEvents){
                            Integer id = Integer.parseInt(eventID);
                            // Add event to student's waitlist
                            student.addToWaitlistedE(id);

                            // Add student to event's waitlist
                            Event event = eventManager.getEventById(id);

                            if(event != null){
                                event.addToWaitlist(student);
                            }
                        }
                    }
     
                }
            }
            catch (FileNotFoundException e){
                System.out.println("Student file not found. Continuing without student data");
            }
            catch (IOException e){
                System.out.println("Error loading students: " + e.getMessage());
            }
        }
    
}


