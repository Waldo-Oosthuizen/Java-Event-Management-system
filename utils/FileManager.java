package utils;
// Adapted from Gupta (2025) and Oracle (n.d)
import java.io.*;

import managers.EventManager;
import models.Event;

import java.time.LocalDate;
import java.time.LocalTime;

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
         System.out.println("Event Data has successfully been saved.");
        }
        catch (IOException e){
            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    // Load events
    public static void loadEvents(EventManager eventManager){

        try (BufferedReader reader = new BufferedReader(new FileReader("data/events.txt")))
        {
            String line;

            while((line = reader.readLine()) != null){

                // Split the data in the line into individual values
                String[] data = line.split("\\|");

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

}
